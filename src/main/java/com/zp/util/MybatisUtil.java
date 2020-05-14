package com.zp.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
优化思路：
1. 读取配置文件
   优化方案：保证程序运行时，读取配置文件只发生1次。将读取配置文件的操作放置到静态代码块中。
2. 创建SqlSessionFactory
   SqlSessionFactory是重量级的对象，占据更多的内存，创建成本更高。
   优化方案：SqlSessionFactory做成单例对象。(饿汉式)
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            InputStream is = Resources.getResourceAsStream ("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder ().build (is);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static SqlSession openSession(){
        return sqlSessionFactory.openSession ();
    }

    public static void close(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close ();
        }
    }

    public static void main(String[] args) {
        System.out.println (openSession ().getConnection ());
    }
}
