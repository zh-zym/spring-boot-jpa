
package com.example.demo.commons.baseRepository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 使用Long做主键的
 * @param <T>
 */
@NoRepositoryBean
public interface Repository<T,ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

}
