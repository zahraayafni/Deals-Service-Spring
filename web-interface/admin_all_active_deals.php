<?php

	$curl = curl_init();
	curl_setopt_array($curl, array(
		CURLOPT_URL => "deals-service-spring.herokuapp.com/deals/active",
		CURLOPT_RETURNTRANSFER => true,
		CURLOPT_TIMEOUT => 30,
  		CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  		CURLOPT_CUSTOMREQUEST => "GET",
  		CURLOPT_HTTPHEADER => array(
    		"cache-control: no-cache"
  		),
	));

	$response = curl_exec($curl);
	
	/* Check for 404 (file not found). */
    $httpCode = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    // Check the HTTP Status code
    switch ($httpCode) {
        case 200:
            $error_status = "200: Success";
            $allDeals = json_decode($response, true); 	
            break;
        case 404:
            $error_status = "404: API Not found";
            break;
        case 500:
            $error_status = "500: servers replied with an error.";
            break;
        case 502:
            $error_status = "502: servers may be down or being upgraded. Hopefully they'll be OK soon!";
            break;
        case 503:
            $error_status = "503: service unavailable. Hopefully they'll be OK soon!";
            break;
        default:
            $error_status = "Undocumented error: " . $httpCode . " : " . curl_error($curl);
            break;
    }

	curl_close($curl);
?>

<!DOCTYPE html>
<html>
<head>
	<title>Get All Active Restaurant Deals</title>

	<style type="text/css">
		.head {
			padding-left: 5px;
			display: inline-flex;
			list-style: none;
		}
	</style>
</head>
<body>

<header>
	<ul>
		<li class="head"><h1>Deals of All Restaurant</h1></li>
		<li class="head"><?php echo '<a href="admin_all_active_deals.php">Active</a>' ?></li>
		<li class="head"><?php echo '<a href="admin_all_expired_deals.php">Expired</a>' ?></li>
	</ul>	
</header>

<h4>Active Deals</h4>

<table>
	<thead>
		<th>ID</th>
		<th>ID Restaurant</th>
		<th>Kode Voucher</th>
		<th>Name</th>
		<th>Description</th>
		<th>Besar Diskon</th>
		<th>Maksimum Diskon</th>
		<th>Belanja Minimal</th>
		<th>Mulai</th>
		<th>Hingga</th>
		<th>Actions</th>
	</thead>

	<tbody>
		<?php
			for ($i=0; $i < sizeof($allDeals); $i++) {
		?>
		<tr>
			<td><?php echo $allDeals[$i]['id'] ?></td>
			<td><?php echo $allDeals[$i]['r_id'] ?></td>
			<td><?php echo $allDeals[$i]['code'] ?></td>
			<td><?php echo $allDeals[$i]['name'] ?></td>
			<td><?php echo $allDeals[$i]['description'] ?></td>
			<td><?php echo $allDeals[$i]['amount'] ?></td>
			<td><?php echo $allDeals[$i]['max_val'] ?></td>
			<td><?php echo $allDeals[$i]['min_val'] ?></td>
			<td><?php echo $allDeals[$i]['start'] ?></td>
			<td><?php echo $allDeals[$i]['end_time'] ?></td>
			<td>
				<ul>
					<li class="head"><?php echo '<a href="voucher_details.php?r_id='.$allDeals[$i]['r_id'].'&'.'id='.$allDeals[$i]['id'].'">Details</a>' ?></li>
					<li class="head"><?php echo '<a href="edit_voucher.php?r_id='.$allDeals[$i]['r_id'].'&'.'id='.$allDeals[$i]['id'].'">Edit</a>' ?></li>
					<li class="head"><?php echo '<a href="delete_voucher.php?r_id='.$allDeals[$i]['r_id'].'&'.'id='.$allDeals[$i]['id'].'">Delete</a>' ?></li>
				</ul>
			</td>
		</tr>

		<?php 			
			}
		?>
	</tbody>
</table>

</body>
</html>