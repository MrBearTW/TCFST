import json
with open('OTC.txt')as f:
    decodejson = json.load(f)

    #print(decodejson)
    #print(type(decodejson))

    infoArray= decodejson["infoArray"]
    print(decodejson["infoArray"][0]["l"])  #140.53
    print(decodejson["infoArray"][0]["h"])  #142.06


#    'infoArray': [{'ex': 'otc', 'd': '20171002', 'it': 't', 'c': 'o00', 'n': '櫃買指數', 'o': '140.53', 'l': '140.53', 'tk0':
#'o00.tw_otc_20171002_B_9999787884', 'h': '142.06', 'tk1': 'o00.tw_otc_20171002_B_0000000o00', 'i': 'oidx.tw', 'ip': '0', 'bt': '11:41:30', 'v': '20881', 't':
# '11:41:30', 'tlong': '1506915690000', 'ch': 'o00.tw', 'z': '142.02', 'y': '140.42'}], 'rtcode': '0000', 'size': 162}
#<class 'dict'>
