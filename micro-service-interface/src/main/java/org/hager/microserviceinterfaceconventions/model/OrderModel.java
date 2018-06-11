package org.hager.microserviceinterfaceconventions.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author wzh
 * @date: 2018/06/11
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderModel implements Serializable {

    private Long orderId;

    private Long userId;

    private String orderName;

    private Timestamp createTime;
}
