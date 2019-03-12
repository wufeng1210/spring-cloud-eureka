package com.spring.activi.demo.util;

import com.spring.activi.demo.pojo.Functions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wufeng
 * @date: 2018/7/3 11:28
 * @desrcption: 我的堆实现方式；实现方案，
 * 将数据放入堆中，然后判断堆节点是否含有该节点数据，如果没有，则插入，如果有则判断，是否为自身父节点，
 * 如果是，则插入父节点的下方转为子节点
 */
public class MyHead {

    private List<Functions> mHeap;

    public MyHead(){
        this.mHeap = new ArrayList<>();
    }
    /*
     * 最小堆的向上调整算法(从start开始向上直到0，调整堆)
     *
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *
     * 参数说明：
     *     start -- 被上调节点的起始位置(一般为数组中最后一个元素的索引)
     */
    protected void filterup(int start) {
        int c = start;            // 当前节点(current)的位置
        Functions tmp = mHeap.get(c);        // 当前节点(current)的大小

        for(int i =0; i < mHeap.size(); i++) {
            Functions cmp = mHeap.get(i);
            if(cmp.getSuffix() < tmp.getSuffix() && cmp.getEndIndex() > tmp.getEndIndex()){
                mHeap.set(c, mHeap.get(i));
                mHeap.set(c-1, tmp);
                c = start;
            }
        }
        if(start == 0){
            mHeap.set(c, tmp);
        }
    }

    public List<Functions> insert(Functions data) {
        int size = mHeap.size();

        mHeap.add(data);    // 将"数组"插在表尾
        filterup(size);        // 向上调整堆
        return mHeap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<mHeap.size(); i++)
            sb.append(mHeap.get(i).getFunction() +" ");

        return sb.toString();
    }
}
