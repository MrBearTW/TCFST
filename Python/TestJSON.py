import json
with open('OTC.txt')as f:
    decodejson = json.load(f)
    print(decodejson)
    print(type(decodejson))