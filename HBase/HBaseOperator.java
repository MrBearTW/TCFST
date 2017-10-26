package my.hbase.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseOperator {

	private static Connection conn = null;

	private static String resoucePATH = "/home/cloudera/workspace/hbaseTest/resource/";
	private static String coreSite = "core-site.xml";
	private static String hbaseSite = "hbase-site.xml";
	private static String hdfsSite = "hdfs-site.xml";

	static {
		Configuration conf = HBaseConfiguration.create();
		// conf.addResource(resoucePATH + coreSite);
		// conf.addResource(resoucePATH + hbaseSite);
		// conf.addResource(resoucePATH + hdfsSite);

		conf.addResource("./resource/" + coreSite);
		conf.addResource("./resource/" + hbaseSite);
		conf.addResource("./resource/" + hdfsSite);

		// conf.set("hbase.zookeeper.quorum", "master");
		// conf.set("hbase.rootdir", "hdfs://localhost:60000/hbase");
		// conf.setBoolean("hbase.cluster.distributed", false);
		// conf.setInt("hbase.client.scanner.caching", 10000);
		// conf.set("zookeeper.znode.parent", "/hbase");

		// conf.set("zookeeper.znode.parent", "/hbase-secure");
		// conf.set("hbase.zookeeper.property.clientPort", "2181");
		// conf.set("hbase.zookeeper.quorum", "xxxxxxxxxxxxxx");
		// conf.set("hbase.master", "xxxxxxxxxxxxx");
		try {
			conn = ConnectionFactory.createConnection(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create table
	 * 
	 * @param tablename
	 * @param cfs
	 */
	public static void createTable(String tablename, String[] cfs) {
		try {
			HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
			// HBaseAdmin admin = new HBaseAdmin(conf);
			if (admin.tableExists(tablename)) {
				System.out.println("table already exists!");
			} else {
				HTableDescriptor tableDesc = new HTableDescriptor(
						TableName.valueOf(tablename));
				for (int i = 0; i < cfs.length; i++) {
					tableDesc.addFamily(new HColumnDescriptor(cfs[i]));
				}
				admin.createTable(tableDesc);
				admin.close();
				System.out.println("create table " + tablename + " ok.");
			}

		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete Table
	 * 
	 * @param tablename
	 */
	public static void deleteTable(String tablename) {
		try {
			HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
			admin.disableTable(tablename);
			admin.deleteTable(tablename);
			System.out.println("delete table " + tablename + " ok.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addColumn(String tableName, String family) {
		try {
			HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
			HColumnDescriptor column = new HColumnDescriptor(family);
			admin.addColumn(tableName, column);
			System.out.println("coloumn added");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void delColumn(String tableName, String family) {
		try {
			HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
			admin.deleteColumn(tableName, family);
			System.out.println("coloumn deleted");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void modifyColumn(String tableName, String family) {
		try {
			HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
			HColumnDescriptor column = new HColumnDescriptor(family);
			admin.modifyColumn(tableName, column);
			System.out.println("coloumn changed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add a new record
	 * 
	 * @param tableName
	 * @param rowKey
	 * @param family
	 * @param qualifier
	 * @param value
	 * @throws IOException 
	 */
	public static void addRecord(String tableName, String rowKey,
			String family, String qualifier, String value) throws IOException {
		try {
			HTable table = (HTable) conn.getTable(TableName.valueOf(tableName));
			Put recored = new Put(Bytes.toBytes(rowKey));
			recored.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier),
					Bytes.toBytes(value));
			table.put(recored);
			System.out.println("insert recored " + rowKey + " to table "
					+ tableName + " ok.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete an exist record
	 * 
	 * @param tableName
	 * @param rowKey
	 */
	public static void delRecord(String tableName, String rowKey) {
		try {
			HTable table = (HTable) conn.getTable(TableName.valueOf(tableName));
//			List<Delete> list = new ArrayList<Delete>();
			Delete del = new Delete(rowKey.getBytes());
//			list.add(del);
//			table.delete(list);
			table.delete(del);
			System.out.println("del recored " + rowKey + " ok.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get one record
	 * 
	 * @param tableName
	 * @param rowKey
	 */
	public static void getOneRecord(String tableName, String rowKey){
		try{
			HTable table = (HTable) conn.getTable(TableName.valueOf(tableName));
			Get get = new Get(rowKey.getBytes());
			Result rs = table.get(get);
			for (Cell kv : rs.rawCells()) {
				System.out.print(new String(kv.getRow()) + " ");
				System.out.print(new String(kv.getFamily()) + ":");
				System.out.print(new String(kv.getQualifier()) + " ");
				System.out.print(kv.getTimestamp() + " ");
				System.out.println(new String(kv.getValue()));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get a record
	 * 
	 * @param tableName
	 * @param rowKey
	 */
	public static void getARecord(String tableName, String rowKey) {
		try {
			HTable table = (HTable) conn.getTable(TableName.valueOf(tableName));
			Get get = new Get(rowKey.getBytes());
			Result rs = table.get(get);
			NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = rs.getMap();
			Set<byte[]> cfSet = map.keySet();
			NavigableMap<byte[], byte[]> quMap = null;

			for (byte[] cf : cfSet) {
				System.out.println("CFamily : " + new String(cf));
				quMap = rs.getFamilyMap(cf);
				System.out.println();
				for (Map.Entry<byte[], byte[]> ent : quMap.entrySet()) {
					System.out.println("Qualifier : " + new String(ent.getKey()));
					System.out.println("Value : " + new String(ent.getValue()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scan table
	 * 
	 * @param tableName
	 */
	public static void getAllRecord(String tableName) {
		try {
			HTable table = (HTable) conn.getTable(TableName.valueOf(tableName));
			Scan s = new Scan();
			ResultScanner ss = table.getScanner(s);
			for (Result r : ss) {
				for (Cell kv : r.rawCells()) {
					System.out.print(new String(kv.getRow()) + " ");
					System.out.print(new String(kv.getFamily()) + ":");
					System.out.print(new String(kv.getQualifier()) + " ");
					System.out.print(kv.getTimestamp() + " ");
					System.out.println(new String(kv.getValue()));
				}
			}
			System.out.println("end");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * "list" command
	 */
	public static void showAllTable(){
		try {
			HBaseAdmin admin = (HBaseAdmin) conn.getAdmin();
			TableName[] tables = admin.listTableNames();
			System.out.println("TABLE");
			for(TableName table : tables){
				System.out.println(table.getNameAsString());
			}
			System.out.println(String.format("%-2d row(s) ", tables.length));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
