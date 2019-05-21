<?php

    $token = $_GET['token'];
	$r_id = $_GET['r_id'];
	$id = $_GET['id'];
	$curl = curl_init();
	curl_setopt_array($curl, array(
		CURLOPT_URL => "deals-service-spring.herokuapp.com/deals/".$r_id."/".$id,
		CURLOPT_RETURNTRANSFER => true,
		CURLOPT_TIMEOUT => 30,
  		CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  		CURLOPT_CUSTOMREQUEST => "DELETE",
  		CURLOPT_HTTPHEADER => array(
    		'Authorization: '.$token
  		),
	));

	$response = curl_exec($curl);

	/* Check for 404 (file not found). */
    $httpCode = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    // Check the HTTP Status code
    switch ($httpCode) {
        case 200:
            $error_status = "200: Success";
            header("Location: get_all_deals.php?token=".$token); 
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
	echo $error_status;
?>