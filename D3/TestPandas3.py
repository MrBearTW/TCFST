import pandas as pd
df = pd.read_json('sample.json')
'''
[{
    "name": "apple",
    "age": "18"
},{
    "name": "pen",
    "age": "55"
},{
    "name": "bananan",
    "age": "66"
}]
'''

df.to_json('sample_records.json', orient='records')
# [{"age":18,"name":"apple"},{"age":55,"name":"pen"},{"age":66,"name":"bananan"}]
'''
[{
	"age": 18,
	"name": "apple"
}, {
	"age": 55,
	"name": "pen"
}, {
	"age": 66,
	"name": "bananan"
}]
'''
df.to_json('sample_split.json', orient='split')
# {"columns":["age","name"],"index":[0,1,2],"data":[[18,"apple"],[55,"pen"],[66,"bananan"]]}
'''
{
	"columns": ["age", "name"],
	"index": [0, 1, 2],
	"data": [
		[18, "apple"],
		[55, "pen"],
		[66, "bananan"]
	]
}
'''
df.to_json('sample_columns.json', orient='columns')
# {"age":{"0":18,"1":55,"2":66},"name":{"0":"apple","1":"pen","2":"bananan"}}
'''
{
	"age": {
		"0": 18,
		"1": 55,
		"2": 66
	},
	"name": {
		"0": "apple",
		"1": "pen",
		"2": "bananan"
	}
}
'''
df.to_json('sample_index.json', orient='index')
# {"0":{"age":18,"name":"apple"},"1":{"age":55,"name":"pen"},"2":{"age":66,"name":"bananan"}}
'''
{
	"0": {
		"age": 18,
		"name": "apple"
	},
	"1": {
		"age": 55,
		"name": "pen"
	},
	"2": {
		"age": 66,
		"name": "bananan"
	}
}
'''
df.to_json('sample_values.json', orient='values')
# [[18,"apple"],[55,"pen"],[66,"bananan"]]
'''
[
	[18, "apple"],
	[55, "pen"],
	[66, "bananan"]
]
'''
