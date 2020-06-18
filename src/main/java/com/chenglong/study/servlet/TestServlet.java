package com.chenglong.study.servlet;

import com.chenglong.study.model.RespCode;
import com.chenglong.study.model.RespEntity;
import com.chenglong.study.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author v_longcheng
 * @date 2019/6/21
 * @description
 */
@Slf4j
@WebServlet(urlPatterns = "/servlet/*")
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("doGet-----------------------");

        //设置编码格式为UTF-8
        resp.setCharacterEncoding("UTF-8");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        resp.setHeader("content-type", "application/json;charset=UTF-8");
        outPutPrintWriter(resp);


    }

    private void outPutPrintWriter(HttpServletResponse resp) throws IOException {

        RespEntity respEntity = new RespEntity(RespCode.SUCCESS);

        respEntity.setData("输出的内容");
        PrintWriter printWriter = resp.getWriter();

        String s = JsonUtils.generate(respEntity);

        printWriter.write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("doPost-----------------------");


    }
}
