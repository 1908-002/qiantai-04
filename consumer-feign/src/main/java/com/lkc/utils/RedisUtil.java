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
 * name�����ڷ�װRedisTemplate����ʹ�ã���װredis���÷���
 * author��LiuC
 * date��2020-04-01*/
@Component  // ��������Ϊspring�����ļ��࣬ע��spring��������
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * ָ������ʧЧʱ��
     * @param key  ��
     * @param time ʱ��(��)
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
     * ����key ��ȡ����ʱ��
     * 45
     *
     * @param key �� ����Ϊnull
     *            46
     * @return ʱ��(��) ����0����Ϊ������Ч
     * 47
     */

    public long getExpire(String key) {

        return redisTemplate.getExpire(key, TimeUnit.SECONDS);

    }

    /**
     * 53
     * �ж�key�Ƿ����
     * 54
     *
     * @param key ��
     *            55
     * @return true ���� false������
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
     * ɾ������
     * 68
     *
     * @param key ���Դ�һ��ֵ ����
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
     * ��ͨ�����ȡ
     * 84
     *
     * @param key ��
     *            85
     * @return ֵ
     * 86
     */

    public Object get(String key) {

        return key == null ? null : redisTemplate.opsForValue().get(key);

    }

    /**
     * 92
     * ��ͨ�������
     * 93
     *
     * @param key   ��
     *              94
     * @param value ֵ
     *              95
     * @return true�ɹ� falseʧ��
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
     * ��ͨ������벢����ʱ��
     * 110
     *
     * @param key   ��
     *              111
     * @param value ֵ
     *              112
     * @param time  ʱ��(��) timeҪ����0 ���timeС�ڵ���0 ������������
     *              113
     * @return true�ɹ� false ʧ��
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
     * ����
     * 131
     *
     * @param key   ��
     *              132
     * @param delta Ҫ���Ӽ�(����0)
     *              133
     * @return 134
     */

    public long incr(String key, long delta) {

        if (delta < 0) {

            throw new RuntimeException("�������ӱ������0");

        }

        return redisTemplate.opsForValue().increment(key, delta);

    }

    /**
     * 143
     * �ݼ�
     * 144
     *
     * @param key   ��
     *              145
     * @param delta Ҫ���ټ�(С��0)
     *              146
     * @return 147
     */

    public long decr(String key, long delta) {

        if (delta < 0) {

            throw new RuntimeException("�ݼ����ӱ������0");

        }

        return redisTemplate.opsForValue().increment(key, -delta);

    }

    // ================================Map=================================

    /**
     * 157
     * HashGet
     * 158
     *
     * @param key  �� ����Ϊnull
     *             159
     * @param item �� ����Ϊnull
     *             160
     * @return ֵ
     * 161
     */

    public Object hget(String key, String item) {

        return redisTemplate.opsForHash().get(key, item);

    }

    /**
     * 167
     * ��ȡhashKey��Ӧ�����м�ֵ
     * 168
     *
     * @param key ��
     *            169
     * @return ��Ӧ�Ķ����ֵ
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
     * @param key ��
     *            178
     * @param map ��Ӧ�����ֵ
     *            179
     * @return true �ɹ� false ʧ��
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
     * HashSet ������ʱ��
     * 193
     *
     * @param key  ��
     *             194
     * @param map  ��Ӧ�����ֵ
     *             195
     * @param time ʱ��(��)
     *             196
     * @return true�ɹ� falseʧ��
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
     * ��һ��hash���з�������,��������ڽ�����
     * 213
     *
     * @param key   ��
     *              214
     * @param item  ��
     *              215
     * @param value ֵ
     *              216
     * @return true �ɹ� falseʧ��
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
     * ��һ��hash���з�������,��������ڽ�����
     * 230
     *
     * @param key   ��
     *              231
     * @param item  ��
     *              232
     * @param value ֵ
     *              233
     * @param time  ʱ��(��) ע��:����Ѵ��ڵ�hash����ʱ��,���ｫ���滻ԭ�е�ʱ��
     *              234
     * @return true �ɹ� falseʧ��
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
     * ɾ��hash���е�ֵ
     * 251
     *
     * @param key  �� ����Ϊnull
     *             252
     * @param item �� ����ʹ��� ����Ϊnull
     *             253
     */

    public void hdel(String key, Object... item) {

        redisTemplate.opsForHash().delete(key, item);

    }

    /**
     * 259
     * �ж�hash�����Ƿ��и����ֵ
     * 260
     *
     * @param key  �� ����Ϊnull
     *             261
     * @param item �� ����Ϊnull
     *             262
     * @return true ���� false������
     * 263
     */

    public boolean hHasKey(String key, String item) {

        return redisTemplate.opsForHash().hasKey(key, item);

    }

    /**
     * 269
     * hash���� ���������,�ͻᴴ��һ�� �����������ֵ����
     * 270
     *
     * @param key  ��
     *             271
     * @param item ��
     *             272
     * @param by   Ҫ���Ӽ�(����0)
     *             273
     * @return 274
     */

    public double hincr(String key, String item, double by) {

        return redisTemplate.opsForHash().increment(key, item, by);

    }

    /**
     * 280
     * hash�ݼ�
     * 281
     *
     * @param key  ��
     *             282
     * @param item ��
     *             283
     * @param by   Ҫ���ټ�(С��0)
     *             284
     * @return 285
     */

    public double hdecr(String key, String item, double by) {

        return redisTemplate.opsForHash().increment(key, item, -by);

    }

    // ============================set=============================

    /**
     * 292
     * ����key��ȡSet�е�����ֵ
     * 293
     *
     * @param key ��
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
     * ����value��һ��set�в�ѯ,�Ƿ����
     * 307
     *
     * @param key   ��
     *              308
     * @param value ֵ
     *              309
     * @return true ���� false������
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
     * �����ݷ���set����
     * 322
     *
     * @param key    ��
     *               323
     * @param values ֵ �����Ƕ��
     *               324
     * @return �ɹ�����
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
     * ��set���ݷ��뻺��
     * 337
     *
     * @param key    ��
     *               338
     * @param time   ʱ��(��)
     *               339
     * @param values ֵ �����Ƕ��
     *               340
     * @return �ɹ�����
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
     * ��ȡset����ĳ���
     * 356
     *
     * @param key ��
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
     * �Ƴ�ֵΪvalue��
     * 370
     *
     * @param key    ��
     *               371
     * @param values ֵ �����Ƕ��
     *               372
     * @return �Ƴ��ĸ���
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
     * ��ȡlist���������
     * 387
     *
     * @param key   ��
     *              388
     * @param start ��ʼ
     *              389
     * @param end   ���� 0 �� -1��������ֵ
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
     * ��ȡlist����ĳ���
     * 403
     *
     * @param key ��
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
     * ͨ������ ��ȡlist�е�ֵ
     * 417
     *
     * @param key   ��
     *              418
     * @param index ���� index>=0ʱ�� 0 ��ͷ��1 �ڶ���Ԫ�أ��������ƣ�index<0ʱ��-1����β��-2�����ڶ���Ԫ�أ���������
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
     * ��list���뻺��
     * 432
     *
     * @param key   ��
     *              433
     * @param value ֵ
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
     * ��list���뻺��
     *
     * @param key   ��
     * @param value ֵ
     * @param time  ʱ��(��)
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
     * ��list���뻺��
     * 468
     *
     * @param key   ��
     *              469
     * @param value ֵ
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
     * ��list���뻺��
     * 485
     * <p>
     * 486
     *
     * @param key   ��
     *              487
     * @param value ֵ
     *              488
     * @param time  ʱ��(��)
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
     * ���������޸�list�е�ĳ������
     * 505
     *
     * @param key   ��
     *              506
     * @param index ����
     *              507
     * @param value ֵ
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
     * �Ƴ�N��ֵΪvalue
     * 522
     *
     * @param key   ��
     *              523
     * @param count �Ƴ����ٸ�
     *              524
     * @param value ֵ
     *              525
     * @return �Ƴ��ĸ���
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
    //��ȡ���м�
    public Set<String> keys(String key){
        Set<String> keys = redisTemplate.keys(key);
        return keys;
    }
    //ɾ�����м�
    public void delAllKeys(String key){
        Set<String> keys = redisTemplate.keys(key);
        redisTemplate.delete(keys);
    }


}
