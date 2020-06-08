package com.lkc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * name????????RedisTemplate???????????redis????????
 * author??LiuC
 * date??2020-04-01*/
@Component  // ?????????spring????????????spring????????
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * ????????¡ì????
     * @param key  ??
     * @param time ???(??)
     * @return 30*/
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 44
     * ????key ??????????
     * 45
     *
     * @param key ?? ?????null
     *            46
     * @return ???(??) ????0???????????¡ì?
     * 47
     */

    public long getExpire(String key) {

        return redisTemplate.getExpire(key, TimeUnit.SECONDS);

    }

    /**
     * 53
     * ?¡ì??key??????
     * 54
     *
     * @param key ??
     *            55
     * @return true ???? false??????
     * 56
     */

    public boolean hasKey(String key) {

        try {

            return redisTemplate.hasKey(key);

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 67
     * ???????
     * 68
     *
     * @param key ????????? ????
     *            69
     */

    @SuppressWarnings("unchecked")

    public void del(String... key) {

        if (key != null && key.length > 0) {

            if (key.length == 1) {

                redisTemplate.delete(key[0]);

            } else {

                redisTemplate.delete(CollectionUtils.arrayToList(key));

            }

        }

    }

    // ============================String=============================

    /**
     * 83
     * ?????????
     * 84
     *
     * @param key ??
     *            85
     * @return ?
     * 86
     */

    public Object get(String key) {

        return key == null ? null : redisTemplate.opsForValue().get(key);

    }

    /**
     * 92
     * ??????????
     * 93
     *
     * @param key   ??
     *              94
     * @param value ?
     *              95
     * @return true??? false???
     * 96
     */

    public boolean set(String key, Object value) {

        try {

            redisTemplate.opsForValue().set(key, value);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 109
     * ?????????????????
     * 110
     *
     * @param key   ??
     *              111
     * @param value ?
     *              112
     * @param time  ???(??) time?????0 ???time¡ì??????0 ????????????
     *              113
     * @return true??? false ???
     * 114
     */

    public boolean set(String key, Object value, long time) {

        try {

            if (time > 0) {

                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);

            } else {

                set(key, value);

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 130
     * ????
     * 131
     *
     * @param key   ??
     *              132
     * @param delta ??????(????0)
     *              133
     * @return 134
     */

    public long incr(String key, long delta) {

        if (delta < 0) {

            throw new RuntimeException("??????????????0");

        }

        return redisTemplate.opsForValue().increment(key, delta);

    }

    /**
     * 143
     * ???
     * 144
     *
     * @param key   ??
     *              145
     * @param delta ??????(¡ì???0)
     *              146
     * @return 147
     */

    public long decr(String key, long delta) {

        if (delta < 0) {

            throw new RuntimeException("?????????????0");

        }

        return redisTemplate.opsForValue().increment(key, -delta);

    }

    // ================================Map=================================

    /**
     * 157
     * HashGet
     * 158
     *
     * @param key  ?? ?????null
     *             159
     * @param item ?? ?????null
     *             160
     * @return ?
     * 161
     */

    public Object hget(String key, String item) {

        return redisTemplate.opsForHash().get(key, item);

    }

    /**
     * 167
     * ???hashKey????????¡ì???
     * 168
     *
     * @param key ??
     *            169
     * @return ??????????
     * 170
     */

    public Map<Object, Object> hmget(String key) {

        return redisTemplate.opsForHash().entries(key);

    }

    /**
     * 176
     * HashSet
     * 177
     *
     * @param key ??
     *            178
     * @param map ?????????
     *            179
     * @return true ??? false ???
     * 180
     */

    public boolean hmset(String key, Map<String, Object> map) {

        try {

            redisTemplate.opsForHash().putAll(key, map);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 192
     * HashSet ?????????
     * 193
     *
     * @param key  ??
     *             194
     * @param map  ?????????
     *             195
     * @param time ???(??)
     *             196
     * @return true??? false???
     * 197
     */

    public boolean hmset(String key, Map<String, Object> map, long time) {

        try {

            redisTemplate.opsForHash().putAll(key, map);

            if (time > 0) {

                expire(key, time);

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 212
     * ?????hash???¡ì????????,??????????????
     * 213
     *
     * @param key   ??
     *              214
     * @param item  ??
     *              215
     * @param value ?
     *              216
     * @return true ??? false???
     * 217
     */

    public boolean hset(String key, String item, Object value) {

        try {

            redisTemplate.opsForHash().put(key, item, value);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 229
     * ?????hash???¡ì????????,??????????????
     * 230
     *
     * @param key   ??
     *              231
     * @param item  ??
     *              232
     * @param value ?
     *              233
     * @param time  ???(??) ???:?????????hash???????,????????I??¡ì?????
     *              234
     * @return true ??? false???
     * 235
     */

    public boolean hset(String key, String item, Object value, long time) {

        try {

            redisTemplate.opsForHash().put(key, item, value);

            if (time > 0) {

                expire(key, time);

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 250
     * ???hash???¡ì???
     * 251
     *
     * @param key  ?? ?????null
     *             252
     * @param item ?? ???????? ?????null
     *             253
     */

    public void hdel(String key, Object... item) {

        redisTemplate.opsForHash().delete(key, item);

    }

    /**
     * 259
     * ?¡ì??hash????????¡ì??????
     * 260
     *
     * @param key  ?? ?????null
     *             261
     * @param item ?? ?????null
     *             262
     * @return true ???? false??????
     * 263
     */

    public boolean hHasKey(String key, String item) {

        return redisTemplate.opsForHash().hasKey(key, item);

    }

    /**
     * 269
     * hash???? ?????????,???????? ????????????????
     * 270
     *
     * @param key  ??
     *             271
     * @param item ??
     *             272
     * @param by   ??????(????0)
     *             273
     * @return 274
     */

    public double hincr(String key, String item, double by) {

        return redisTemplate.opsForHash().increment(key, item, by);

    }

    /**
     * 280
     * hash???
     * 281
     *
     * @param key  ??
     *             282
     * @param item ??
     *             283
     * @param by   ??????(¡ì???0)
     *             284
     * @return 285
     */

    public double hdecr(String key, String item, double by) {

        return redisTemplate.opsForHash().increment(key, item, -by);

    }

    // ============================set=============================

    /**
     * 292
     * ????key???Set?¡ì???????
     * 293
     *
     * @param key ??
     *            294
     * @return 295
     */

    public Set<Object> sGet(String key) {

        try {

            return redisTemplate.opsForSet().members(key);

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }

    /**
     * 306
     * ????value?????set?¡ì???,??????
     * 307
     *
     * @param key   ??
     *              308
     * @param value ?
     *              309
     * @return true ???? false??????
     * 310
     */

    public boolean sHasKey(String key, Object value) {

        try {

            return redisTemplate.opsForSet().isMember(key, value);

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 321
     * ?????????set????
     * 322
     *
     * @param key    ??
     *               323
     * @param values ? ????????
     *               324
     * @return ???????
     * 325
     */

    public long sSet(String key, Object... values) {

        try {

            return redisTemplate.opsForSet().add(key, values);

        } catch (Exception e) {

            e.printStackTrace();

            return 0;

        }

    }

    /**
     * 336
     * ??set?????????
     * 337
     *
     * @param key    ??
     *               338
     * @param time   ???(??)
     *               339
     * @param values ? ????????
     *               340
     * @return ???????
     * 341
     */

    public long sSetAndTime(String key, long time, Object... values) {

        try {

            Long count = redisTemplate.opsForSet().add(key, values);

            if (time > 0)

                expire(key, time);

            return count;

        } catch (Exception e) {

            e.printStackTrace();

            return 0;

        }

    }

    /**
     * 355
     * ???set????????
     * 356
     *
     * @param key ??
     *            357
     * @return 358
     */

    public long sGetSetSize(String key) {

        try {

            return redisTemplate.opsForSet().size(key);

        } catch (Exception e) {

            e.printStackTrace();

            return 0;

        }

    }

    /**
     * 369
     * ?????value??
     * 370
     *
     * @param key    ??
     *               371
     * @param values ? ????????
     *               372
     * @return ????????
     * 373
     */

    public long setRemove(String key, Object... values) {

        try {

            Long count = redisTemplate.opsForSet().remove(key, values);

            return count;

        } catch (Exception e) {

            e.printStackTrace();

            return 0;

        }

    }

    // ===============================list=================================

    /**
     * 386
     * ???list?????????
     * 387
     *
     * @param key   ??
     *              388
     * @param start ???
     *              389
     * @param end   ???? 0 ?? -1?????????
     *              390
     * @return 391
     */

    public List<Object> lGet(String key, long start, long end) {

        try {

            return redisTemplate.opsForList().range(key, start, end);

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }

    /**
     * 402
     * ???list????????
     * 403
     *
     * @param key ??
     *            404
     * @return 405
     */

    public long lGetListSize(String key) {

        try {

            return redisTemplate.opsForList().size(key);

        } catch (Exception e) {

            e.printStackTrace();

            return 0;

        }

    }

    /**
     * 416
     * ??????? ???list?¡ì???
     * 417
     *
     * @param key   ??
     *              418
     * @param index ???? index>=0??? 0 ?????1 ??????????????????index<0???-1????????-2?????????????????????
     *              419
     * @return 420
     */

    public Object lGetIndex(String key, long index) {

        try {

            return redisTemplate.opsForList().index(key, index);

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }

    /**
     * 431
     * ??list??????
     * 432
     *
     * @param key   ??
     *              433
     * @param value ?
     *              434
     * @return 436
     */

    public boolean lSet(String key, Object value) {

        try {

            redisTemplate.opsForList().rightPush(key, value);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * ??list??????
     *
     * @param key   ??
     * @param value ?
     * @param time  ???(??)
     * @return
     */

    public boolean lSet(String key, Object value, long time) {

        try {

            redisTemplate.opsForList().rightPush(key, value);

            if (time > 0)

                expire(key, time);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 467
     * ??list??????
     * 468
     *
     * @param key   ??
     *              469
     * @param value ?
     *              470
     * @return 472
     */

    public boolean lSet(String key, List<Object> value) {

        try {

            redisTemplate.opsForList().rightPushAll(key, value);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 484
     * ??list??????
     * 485
     * <p>
     * 486
     *
     * @param key   ??
     *              487
     * @param value ?
     *              488
     * @param time  ???(??)
     *              489
     * @return 490
     */

    public boolean lSet(String key, List<Object> value, long time) {

        try {

            redisTemplate.opsForList().rightPushAll(key, value);

            if (time > 0)

                expire(key, time);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 504
     * ???????????list?¡ì?????????
     * 505
     *
     * @param key   ??
     *              506
     * @param index ????
     *              507
     * @param value ?
     *              508
     * @return 509
     */

    public boolean lUpdateIndex(String key, long index, Object value) {

        try {

            redisTemplate.opsForList().set(key, index, value);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 521
     * ???N????value
     * 522
     *
     * @param key   ??
     *              523
     * @param count ????????
     *              524
     * @param value ?
     *              525
     * @return ????????
     * 526
     */

    public long lRemove(String key, long count, Object value) {

        try {

            Long remove = redisTemplate.opsForList().remove(key, count, value);

            return remove;

        } catch (Exception e) {

            e.printStackTrace();

            return 0;

        }

    }
    //??????¡ì??
    public Set<String> keys(String key){
        Set<String> keys = redisTemplate.keys(key);
        return keys;
    }
    //??????¡ì??
    public void delAllKeys(String key){
        Set<String> keys = redisTemplate.keys(key);
        redisTemplate.delete(keys);
    }


}
