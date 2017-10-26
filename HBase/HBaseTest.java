package my.hbase.test;

import java.io.IOException;

import my.hbase.utils.HBaseOperator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HBaseTest {

		public static void main(String[] arg) {
//		testCreateTable();

//		testDeleteTable();
			
//		testGetOneRecord();
			
		testGetAllRecord();
			
//		testAddColumn();
			
//		testDelColumn();
		
//		testModColumn();
			
//		testShowAllTable();
		
	}

	private static void testShowAllTable() {
			HBaseOperator.showAllTable();
		}

	private static void testModColumn() {
		String tableName = "scores";
		String family = "cf1";
		HBaseOperator.modifyColumn(tableName, family);
		}

	private static void testDelColumn() {
		String tableName = "scores";
		String family = "cf";
		HBaseOperator.delColumn(tableName, family);
		}

	private static void testAddColumn(){
		String tableName = "scores";
		String family = "cf";
		HBaseOperator.addColumn(tableName, family);
	}

	private static void testGetAllRecord() {
		String tableName = "scores";
		HBaseOperator.getAllRecord(tableName);
	}

	private static void testGetOneRecord() {
		String tableName = "scores";
		String rowKey = "Tom";
		HBaseOperator.getOneRecord(tableName, rowKey);
	}

	private static void testDeleteTable() {
		String tableName = "hbase.scores12";
		HBaseOperator.deleteTable(tableName);
	}

	private static void testCreateTable() {
		String tableName = "hbase.scores12";
		String[] familys = { "grade", "course" };
		HBaseOperator.createTable(tableName, familys);
	}

}
