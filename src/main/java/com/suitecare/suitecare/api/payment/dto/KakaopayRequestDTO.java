package com.suitecare.suitecare.api.payment.dto;

import lombok.Data;

@Data
public class KakaopayRequestDTO {
    private String cid;
    private String partner_order_id;
    private String partner_user_id;
    private String item_name;
    private Integer quantity;
    private String total_amount;
    private Integer tax_free_amount;
    private String approval_url;
    private String cancel_url;
    private String fail_url;
}
