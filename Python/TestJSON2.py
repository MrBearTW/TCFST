import json
with open('OTC.txt')as f:
    decodejson = json.load(f)

    #print(decodejson)
    #print(type(decodejson))

    infoArray= decodejson["infoArray"]
    print(decodejson["infoArray"][0]["l"])
    print(decodejson["infoArray"][0]["h"])