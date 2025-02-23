package com.example.cqrseslearning.account.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBankRepository extends JpaRepository<AccountBankEntity, Long> {

  AccountBankEntity findByAxonBankAccountId(String id);

}
