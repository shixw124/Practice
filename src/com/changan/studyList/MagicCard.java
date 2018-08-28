package com.changan.studyList;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/27 0027.
 *
 */

import java.util.Arrays;

public class MagicCard {
    public int[] magicDisplay(int cardNum) {
        int[] cards = new int[cardNum];
        for (int i = 0; i < cardNum; i++) {
            cards[i] = 0;
        }
        cards[0] = 1;
        // 指定在何处填值
        int index = 0;
        // 计数（数数）
        int count = 2;

        while (true) {
            for (int i = 1; i <= count; i++) {
                index++;
                while (index > cardNum - 1 && cards[(index - cardNum) % cardNum] != 0) {
                    index++;
                }
            }

            if (index > cardNum - 1 && cards[(index - cardNum) % cardNum] == 0) {
                cards[(index - cardNum) % cardNum] = count;
                count++;
            } else {
                cards[index % cardNum] = count;
                count++;
            }

            if (count > cardNum) {
                break;
            }
        }
        return cards;
    }

    public static void main(String[] args) {

         MagicCard magicCard = new MagicCard();
        int[] a = magicCard.magicDisplay(13);
        System.out.println(Arrays.toString(a));
    }
}
