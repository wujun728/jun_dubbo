package com.jeasy.bid;

import lombok.Data;

import java.io.Serializable;

/**
 * @author TaoBangren
 * @version 1.0
 * @since 2017/5/17 上午9:26
 */
@Data
public class SeatBid implements Serializable {

    private String seat;

    private String group;
}
