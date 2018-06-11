package org.hager.microserviceinterfaceconventions.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author wzh
 * @date: 2018/06/11
 * Description:用户实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserModel implements Serializable {

    private static final long serialVersionUID = 2036257542590224404L;
    private Long userId;
    private String userName;
    private String nickName;
    private Integer age;
}
