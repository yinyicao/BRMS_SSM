package com.yyc.service.impl;

import com.yyc.dao.BookMapper;
import com.yyc.dao.DisOrderMapper;
import com.yyc.entity.Book;
import com.yyc.entity.DisOrder;
import com.yyc.service.DisOrderService;
import com.yyc.vo.RespMsg;
import com.yyc.vo.ResultEnum;
import com.yyc.vo.request.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: SSM
 * @description: 分销订单
 * @author: yyc
 * @create: 2019-11-22 17:17
 **/

@Service("disOrderService")
public class DisOrderServiceImpl implements DisOrderService {

    @Autowired
    private DisOrderMapper disOrderMapper;
    @Autowired
    private BookMapper bookMapper;

    @Transactional
    @Override
    public RespMsg addOrder(OrderVo order) {
        int bookId = order.getId(); //图书ID
        int disNo = order.getDisNo();//分销商id
        double bookPrice = order.getBookPrice();//图书单价
        int orderNumber = order.getOrderNumber();//图书数量
        Date ordDateTime = new Date();//订单时间；
        double ordTotalPrice = bookPrice * orderNumber;//订单总价
        DisOrder disOrder = new DisOrder(disNo,bookId,ordDateTime,orderNumber,
                1,bookPrice,ordTotalPrice,"进行中");

        Book updateBook = new Book();
        updateBook.setId(bookId);
        updateBook.setBookRepertorySize(order.getBookRepertorySize() - orderNumber);

        Integer res = 0;
        Integer res1 = 0;
        try{
            res = this.disOrderMapper.insertDisOrder(disOrder);//插入订单表数据
            res1 = this.bookMapper.updateBook(updateBook); //更新图书库存
            return (res >= 1 && res1>=1) ? new RespMsg(ResultEnum.DISORDER_ADD_SUCCESS,ordTotalPrice):
                    new RespMsg(ResultEnum.ADD_FAILD,res);
        }catch (Exception e){
            if(res > 0){
                return new RespMsg(ResultEnum.DISORDER_ADD_SUCCESS,ordTotalPrice);
            }else{
                return new RespMsg(ResultEnum.ADD_FAILD_UNKNOW,res);
            }
        }
    }
}
