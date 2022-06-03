package com.dustin.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname Cart
 * @Descrption 购物车对象
 * @Date 2021/7/5下午 09:14
 * @Created By Dustin_Peng
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    /**
     * key是商品编号id，
     * value是商品信息
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = new Integer(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        //或者
//        for (CartItem value : items.values()) {
//            totalCount+= value.getCount();
//        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        //先查看购物车是否已添加此商品,已存在的数量进行累加，总金额更新
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            //未添加
            items.put(cartItem.getId(), cartItem);
        } else {
            //已添加
            item.setCount(item.getCount() + 1);//数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }
    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 更改商品数量
     *
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count) {
        //先查看购物车中是否有此商品
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);   //修改商品数量
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));  //更新总金额
        }
    }
}
