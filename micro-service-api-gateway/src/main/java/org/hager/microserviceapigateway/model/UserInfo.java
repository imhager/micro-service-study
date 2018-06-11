package org.hager.microserviceapigateway.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hager.microserviceinterfaceconventions.model.OrderModel;

/**
 * @author wzh
 * @date: 2018/06/09
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 2279382040144264393L;
    private Long userId;
    private String userName;
    private Integer age;

    private List<OrderModel> orderList;
}
