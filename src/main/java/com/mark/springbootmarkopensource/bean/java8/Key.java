package com.mark.springbootmarkopensource.bean.java8;

import java.util.HashMap;

/**
 * ClassName:Key
 * Package:com.mark.springbootmarkopensource.bean.java8
 * Description:
 *
 * @Date:2019/3/20 0020 18:08
 * @Author: mark
 */
public class Key {
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    private byte[] bytes;

    public Key(byte[] bytes) {
        this.bytes = bytes;
    }

    public static void main(String[] args) {
        HashMap<Key, String> map = new HashMap<>();
        Key key = new Key(new byte[]{0x01, 0x02});
        key.setBytes(new byte[]{0x01, 0x02});
        map.put(key, "ABC");
        System.out.println(map.get(key));

        ThreadLocal<String> RESOURCE_1 =
                new ThreadLocal<String>();
        RESOURCE_1.set("one");
    }


    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null)
        {
            return false;
        }

        Key pair = (Key) obj;
        if (this.bytes != pair.bytes) {
            return false;
        }
        return true;
    }
   // @Override
    //public int hashCode() {
        Key key = (Key) this;
        //System.out.println("Hash" + key.bytes);
        return bytes.hashCode();

    }
*/



}
