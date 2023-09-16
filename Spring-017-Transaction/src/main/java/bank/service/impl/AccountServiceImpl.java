package bank.service.impl;

import bank.dao.AccountDao;
import bank.pojo.Account;
import bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //控制事务
    //@Transactional
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        //查询转出账户余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        //余额不足
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("账户余额不足！");
        }
        //余额充足,获取转入账户余额
        Account toAct = accountDao.selectByActno(toActno);
        //修改内存中两个对象的余额
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        //数据库更新
        int count = accountDao.update(fromAct);

/*        String str = null;
        str.toString();*/

        count += accountDao.update(toAct);
        if (count != 2){
            throw new RuntimeException("转账失败！");
        }
    }
}
