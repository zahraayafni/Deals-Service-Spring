# Deals-Service-Spring
A repository for Framework Programming Final Project.
API can be accessed at https://deals-service-spring.herokuapp.com

## API Information
---

| Endpoint  | Method | Function | Required Parameters |
| ------------- | ------------- | ------------- | ------------- |
| /deals | GET | Show all deals | - |
| /deals/active | GET | Show all active deals | - |
| /deals/exp | GET | Show all expired deals | - |
| /deals/{r_id} | GET | Show all deals by restaurant id | - |
| /deals/{r_id}/code | GET | Show all deals by deals code of a restaurant | Voucher's code |
| /deals/{r_id}/active | GET | Show all active deals by restaurant id | - |
| /deals/{r_id}/exp | GET  | Show all expired deals by restaurant id | - |
| /deals/{r_id} | POST  | Create deals | code, name, description, type, amount, max_val, min_val, total_limit_use, limit_use_per_user, limit_one_cust_only, new_cust_only, active_status, start, end_time |
| /deals/{r_id}/{id} | GET | Show deals by id for a restaurant | - |
| /deals/{r_id}/{id} | PUT | Update a deals by id for a restaurant | code, name, description, type, amount, max_val, min_val, total_limit_use, limit_use_per_user, limit_one_cust_only, new_cust_only, active_status, start, end_time |
| /deals/{r_id}/{id} | DELETE | Deactive a deals by id for a restaurant | - |
| /history/check/{u_id} | POST | Check for voucher permission | code, r_id, total_amount |
| /history/user/{u_id} | POST | Use voucher by a user | id, r_id |
| /history/user/{u_id} | GET | Show voucher history of a user | - |
| /history/restaurant/{r_id} | GET | Show voucher history of a restaurant | - |

## Parameter Description
---

## Deals
| Parameter Name  | Type | Description |
| ------------- | ------------- | ------------- |
| id | Integer | Deals id |
| r_id | Integer | Restaurant id |
| code | String | Voucher code |
| name | String | Voucher name |
| desc | String | Voucher Description |
| type | Integer | Voucher type, 0 for percentage and 1 for amount |
| amount | Double | Voucher amount, 2 digits for percentage (ex: 20 for 20% discount) |
| max_val | Double | Discount max amount |
| min_val | Double | The minimum total amount required |
| total_limit_use | Integer | The number of available vouchers |
| limit_use_per_user | Integer | User chance to redeem the voucher |
| new_cust_only | Boolean | Is the voucher limited to the new customer only? |
| active_status | Boolean | Is the voucher available? |
| start | Date | The voucher's start date |
| end | Date | The voucher's end date |
| create_at | Date | The voucher's create date |
| update_at | Date | The voucher's last update date |

## Deals History
| Parameter Name  | Type | Description |
| ------------- | ------------- | ------------- |
| id | Integer | Deals id |
| r_id | Integer | Restaurant id |
| u_id | Integer | User id |
| count | Integer | How many times has the voucher been used? |
| create_at | Date | User's first time redeem the voucher |

<!-- localhost:8080/deals/1?id=1&code=RAMADHAN20&name=Voucher Ramadhan&desc=Ramadhan Ceria&type=0&amount=30&max_val=30000&min_val=20000&total_limit_use=100&limit_use_per_user=3&limit_one_cust_only=0&new_cust_only=1&active_status=1&start=2019-05-10 10:00:00&end=2019-05-15 10:00:00 -->