# -*- coding: utf-8 -*-
import msgpack
import redis
import uuid

def get_idfa():
    return str(uuid.uuid4()).upper()


idfas = []
for i in range(5):
    idfas.append(get_idfa())

payload = {
    'ad_id': 4,
    'url': 'http://127.0.0.1:4567/idfa-qijia',
    'apple_id': '889003085',
    'idfa_type': 0,
    'idfas': idfas,
}

r = redis.StrictRedis()
m = msgpack.packb(payload)

r.rpush('qianka:eeyore:pending_send', m)
