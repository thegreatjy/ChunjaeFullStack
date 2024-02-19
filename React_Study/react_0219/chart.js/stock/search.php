<?php
header('Content-Type: application/json');
header("Access-Control-Allow-Origin: *");

if (!isset($_GET["stock"])){
    $msg = '{"result":"D"}';
    echo json_encode(json_decode($msg));
    exit;
}
$stock = $_GET["stock"];
$stock = htmlspecialchars($stock);

echo file_get_contents($stock.'.json')
?>