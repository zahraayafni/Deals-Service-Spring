<?php

	$r_id = $_GET['r_id'];
	$id = $_GET['id'];
	$curl = curl_init();
	curl_setopt_array($curl, array(
		CURLOPT_URL => "deals-service-spring.herokuapp.com/deals/".$r_id."/".$id,
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
            $deals = json_decode($response, true); 		
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
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<head>
    <meta charset="utf-8" />
    <title>Voucher Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

<div class="page-header">
    <h1 style="color: #223a5e;font-family: 'Baloo Bhai', cursive;">Detail Voucher</h1>
</div>

<!-- Invoice Template - START -->

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 main">
            <div class="col-md-12">
               <div class="row">
                    <div class="col-md-4">
                        <img class="img-responsive" alt="Invoce Template" src="img/icon.png" />
                    </div>
                    <div class="col-md-8 text-right">
                        <h4 style="color: #223a5e;font-family: 'Baloo Bhai', cursive; font-size: 30pt;"><strong><?php echo $deals['name'] ?></strong></h4>
                 
                    </div>
                </div>
                <div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th><h5>ID</h5></th>
                                <th><h5><?php echo $deals['id'] ?></h5></th>
                            </tr>
                        </thead>
                         <thead>
                            <tr>
                                <th><h5>Kode Voucher</h5></th>
                                <th><h5><?php echo $deals['code'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Name</h5></th>
                                <th><h5><?php echo $deals['name'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Description</h5></th>
                                <th><h5><?php echo $deals['description'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Tipe Diskon</h5></th>
                                <th><h5><?php 
                if($deals['type']  === 0)
                    echo "Persen";
                else
                    echo "Potongan Langsung";
            ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Besar Diskon</h5></th>
                                <th><h5><?php echo $deals['amount'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Maksimum Diskon</h5></th>
                                <th><h5><?php echo $deals['max_val'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Belanja Minimal</h5></th>
                                <th><h5><?php echo $deals['min_val'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Banyak  Voucher</h5></th>
                                <th><h5><?php echo $deals['total_limit_use'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Hanya Customer Baru</h5></th>
                                <th><h5><?php 
                if($deals['new_cust_only'] === TRUE)
                    echo "Yes";
                else
                    echo "No";
                ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Status Voucher</h5></th>
                                <th><h5><?php 
                if($deals['active_status'] === TRUE)
                    echo "Active";
                else
                    echo "Non Active";
                ?>  </h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Berlaku Sejak</h5></th>
                                <th><h5><?php echo $deals['start'] ?></h5></th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th><h5>Hingga</h5></th>
                                <th><h5><?php echo $deals['end_time'] ?></h5></th>
                            </tr>
                        </thead>
                        
                    </table>
                </div>
                
            </div>
        </div>
    </div>
</div>

<style>
    .main {
        background: #ffffff;
        border-bottom: 15px solid #223a5e;
        border-top: 15px solid #223a5e;
        margin-top: 30px;
        margin-bottom: 30px;
        padding: 40px 30px !important;
        position: relative;
        box-shadow: 0 1px 21px #808080;
        font-size:10px;
    }

    .main thead {
		background: #1E1F23;
        color: #fff;
		}
</style>
<!-- Invoice Template - END -->

</div>

</body>
</html>