package bank.service;

//业务接口
//事务就是在业务接口下控制的
public interface AccountService {
    /**
     * 转账业务方法
     * @param fromActno 转出的账户
     * @param toActno 转入的账户
     * @param money 转账金额
     */
    void transfer(String fromActno, String toActno, double money);
}
