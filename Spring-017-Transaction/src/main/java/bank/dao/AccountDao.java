package bank.dao;

import bank.pojo.Account;

//负责账户信息的CRUD操作
//Dao只执行SQL语句，没有业务逻辑
public interface AccountDao {

    //根据账号查询账户信息
    Account selectByActno(String actno);

    //更新账户信息
    int update(Account act);
}
