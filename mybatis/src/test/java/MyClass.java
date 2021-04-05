import com.mashibing.bean.Emp;
import com.mashibing.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class MyClass {

    SqlSessionFactory sqlSessionFactory=null;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test//查找
    public  void test01() {
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper=session.getMapper(EmpDao.class);
        //执行具体的SQL语句
        Emp emp=mapper.selectEmpByEmpno(2);
        System.out.println(emp);
        //关闭会话
        session.close();

    }

    @Test//插入
    public void test02(){
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper=session.getMapper(EmpDao.class);
        //执行具体的SQL语句
        Emp emp=new Emp();
        emp.setEname("马士兵");
        emp.setJob("扫地神僧");
        mapper.save(emp);
        session.commit();
        session.close();

    }

    @Test//插入
    public void test03(){
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper=session.getMapper(EmpDao.class);
        //执行具体的SQL语句
        Emp emp=new Emp();
        emp.setEmpno(8);
        emp.setEname("马士");
        emp.setJob("牛人");
        emp.setComm(345.00);
        mapper.update(emp);
        session.commit();
        session.close();

    }

    @Test//插入
    public void test04(){
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper=session.getMapper(EmpDao.class);
        //执行具体的SQL语句
        mapper.delete(9);
        session.commit();
        session.close();

    }

    @Test//查全部
    public void test05() {
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper = session.getMapper(EmpDao.class);
        //执行具体的SQL语句
        mapper.selectAll();
        session.close();
    }

    @Test//按条件查
    public void test06(){
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper=session.getMapper(EmpDao.class);
        //执行具体的SQL语句
        System.out.println(mapper.selectAllByParam(2,10.00));
        session.close();
    }

    @Test//按条件查
    public void test07(){
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper=session.getMapper(EmpDao.class);
        //执行具体的SQL语句

        HashMap map =new HashMap();
                map.put("empno",2);
                map.put("sal",10.00);
        System.out.println(mapper.selectAllByMap(map));
        session.close();
    }


    @Test//按条件查
    public void test08(){
        //获取与数据库相关的会话
        SqlSession session = sqlSessionFactory.openSession();
        //获取对应的映射接口对象
        EmpDao mapper=session.getMapper(EmpDao.class);
        //执行具体的SQL语句
        Emp emp=new Emp();
        emp.setEmpno(8);
        System.out.println(mapper.selectMyEmp(emp));
        session.close();
    }

}
