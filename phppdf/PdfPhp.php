<?php
require("fpdf.php"); 



function createPDF()
{

	$cust = $_POST['customer'];
	$invoice = $_POST['invoiceNum'];
	$amount = $_POST['amount'];


	$pdf = new FPDF();

	$pdf -> AddPage();

	$pdf -> Image('includes/logo.png');

	$pdf -> SetFont("Arial", "B" , 16);

	$pdf -> Cell(200, 10, $cust, 0,1,'C');

	$pdf -> Cell(200, 10, $invoice, 0,2,'C');

	$pdf -> Cell(200, 10, $amount, 0,3,'C');

	$pdf -> Output();

}

createPDF();

?>

