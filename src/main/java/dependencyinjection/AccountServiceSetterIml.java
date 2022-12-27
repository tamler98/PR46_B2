package dependencyinjection;

import pojo.Account;
import pojo.AccountRepository;
import pojo.AccountService;

public class AccountServiceSetterIml implements AccountService{
        private AccountRepository accountRepository;
        public void setAccountRepository(AccountRepository accountRepository) {
            this.accountRepository = accountRepository;
        }
        @Override
        public void transferMoney(long fromAccountId, long toAccountId, double amount) {
            Account sourceAccount = accountRepository.find(fromAccountId); // sourceAccount =1;
            Account targetAccount = accountRepository.find(toAccountId); // targetAccount = 2;
            sourceAccount.setBalance(sourceAccount.getBalance() - amount); //id=1: x - amount: 10: 5
            targetAccount.setBalance(targetAccount.getBalance() + amount); //id=2: u+ amount: 2 : 7
            accountRepository.update(sourceAccount);
            accountRepository.update(targetAccount);
        }

        @Override
        public void depositMoney(long accountId, double amount) throws Exception {
            Account account = accountRepository.find(accountId);
            account.setBalance(account.getBalance() + amount);
            accountRepository.update(account);
        }

        @Override
        public Account getAccount(long accountId) {
            return accountRepository.find(accountId);
        }
    }
