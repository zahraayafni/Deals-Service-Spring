# Deals-Service-Spring
A repository for Framework Programming Final Project

## API Information

| Endpoint  | Method | Function | Required Parameters |
| ------------- | ------------- | ------------- | ------------- |
| /deals | GET | Show all deals | - |
| /deals/active | GET | Show all active deals | - |
| /deals/exp | GET | Show all expired deals | - |
| /deals/{r_id} | GET | Show all deals by restaurant id | - |
| /deals/{r_id}/active | GET | Show all active deals by restaurant id | - |
| /deals/{r_id}/exp | GET  | Show all expired deals by restaurant id | - |
| /deals/{r_id} | POST  | Create deals | id, code, name, desc, type, amount, max_val, min_val, total_limit_use,
				limit_use_per_user, limit_one_cust_only, new_cust_only, active_status, start, end |
| /deals/{r_id}/{id} | GET | Show deals by id for a restaurant | - |
| /deals/{r_id}/{id} | PUT | Update a deals by id for a restaurant | code, name, desc, type, amount,
				max_val, min_val, total_limit_use, limit_use_per_user, limit_one_cust_only, new_cust_only,
				active_status, start, end |
| /deals/{r_id}/{id} | DELETE | Delete a deals by id for a restaurant | - |
| /history/check/{u_id} | POST | Check for voucher permission | id, r_id, total_amount |
| /history/use/{u_id} | POST | Use voucher by a user | id, r_id |
| /history/use/{u_id} | GET | Show voucher history of a user | - |

<!-- localhost:8080/deals/1?id=1&code=RAMADHAN20&name=Voucher Ramadhan&desc=Ramadhan Ceria&type=0&amount=30&max_val=30000&min_val=20000&total_limit_use=100&limit_use_per_user=3&limit_one_cust_only=0&new_cust_only=1&active_status=1&start=2019-05-10 10:00:00&end=2019-05-15 10:00:00 -->