/**
 * 
 */
package com.vowino.sale.point.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vowino.sale.point.model.user.User;

/**
 * @author vctro
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

}
