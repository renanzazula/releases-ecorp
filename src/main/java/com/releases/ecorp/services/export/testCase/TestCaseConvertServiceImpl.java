package com.releases.ecorp.services.export.testCase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestCaseConvertServiceImpl implements TestCaseConvertService {

	private static final Logger logger = LoggerFactory.getLogger(TestCaseConvertServiceImpl.class);

//	@Override
//	public void prepareDataForAuthorizationTemplatesConversion(AuthTemplateDetails template, Map<String, String> replaceValues) {
//		XWPFDocument xdoc = null;
//		ByteArrayOutputStream baos = null;
//		try {
//			xdoc = new XWPFDocument(OPCPackage.open(new ByteArrayInputStream(template.getEStatementCurrentDocFile())));
//
//			for (XWPFParagraph paragraph : xdoc.getParagraphs()) {
//				replaceValues(paragraph, replaceValues);
//			}
//
//			for (XWPFTable tbl : xdoc.getTables()) {
//				for (XWPFTableRow row : tbl.getRows()) {
//					for (XWPFTableCell cell : row.getTableCells()) {
//						for (XWPFParagraph paragraph : cell.getParagraphs()) {
//							replaceValues(paragraph, replaceValues);
//						}
//					}
//				}
//			}
//			baos = new ByteArrayOutputStream();
//			xdoc.write(baos);
//			template.setEStatementCurrentDocFileRawData(baos.toByteArray());
//		} catch (Exception e) {
//			logger.error("prepareDataforPDFConversion -- error replacing data at document {}", template.getTemplateName(), e);
//		} finally {
//			try {
//				if(baos != null) {
//					baos.close();
//				}
//			} catch (IOException e) {
//				logger.error("failure trying to close the doc file {}", template.getTemplateName(), e);
//			}
//		}
//	}
//
//	@Override
//	public void prepareQRCodeImageForAuthorizationTemplatesConversion(AuthTemplateDetails template, DocVerificationQRCodeImage qrCodeImage) {
//		XWPFDocument xdoc = null;
//		ByteArrayOutputStream baos = null;
//		try {
//			xdoc = new XWPFDocument(OPCPackage.open(new ByteArrayInputStream(template.getEStatementCurrentDocFile())));
//
//			findQrCodeTagAndAddImageToDocument(qrCodeImage, xdoc.getParagraphs());
//
//			for (XWPFTable tbl : xdoc.getTables()) {
//				for (XWPFTableRow row : tbl.getRows()) {
//					for (XWPFTableCell cell : row.getTableCells()) {
//						findQrCodeTagAndAddImageToDocument(qrCodeImage, cell.getParagraphs());
//					}
//				}
//			}
//			baos = new ByteArrayOutputStream();
//			xdoc.write(baos);
//			template.setEStatementCurrentDocFileRawData(baos.toByteArray());
//		} catch (Exception e) {
//			logger.error("prepareDataforPDFConversion -- error replacing data at document {}", template.getTemplateName(), e);
//		} finally {
//			try {
//				if(baos != null) {
//					baos.close();
//				}
//			} catch (IOException e) {
//				logger.error("failure trying to close the doc file {}", template.getTemplateName(), e);
//			}
//		}
//	}
//
//	private void findQrCodeTagAndAddImageToDocument(DocVerificationQRCodeImage qrCodeImage, List<XWPFParagraph> paragraphs) throws InvalidFormatException, IOException {
//		StringBuilder runText = new StringBuilder("");
//		for (XWPFParagraph paragraph : paragraphs) {
//			List<XWPFRun> runs = paragraph.getRuns();
//			if (!CollectionUtils.isEmpty(runs)) {
//				XWPFRun firstRun = runs.get(0);
//				runText.setLength(0);
//				runText.append(firstRun.toString());
//
//				for (int i = 1; i <= runs.size() - 1; i++) {
//					if(runs.get(i) != null){
//						runText.append(runs.get(i).toString());
//					}
//				}
//
//				String templateText = runText.toString();
//
//				if(templateText.contains("<QRCode>")) {
//					templateText = templateText.replace("<QRCode>", "");
//					if(isQrGenerationActive()) {
//						firstRun.addPicture(qrCodeImage.getContents(), Document.PICTURE_TYPE_PNG, "qrcode",
//								Units.toEMU(80), Units.toEMU(80));
//					}
//				}
//
//				firstRun.setText(templateText, 0);
//
//				for (int i = runs.size()-1; i > 0; i--) {
//					if(paragraph.getCTP().getHyperlinkArray().length > 0)
//						firstRun.setText(firstRun.getText(0).replace(paragraph.getCTP().getHyperlinkArray()[0].getRArray()[0].getTArray()[0].getStringValue(), ""), 0);
//					else
//						paragraph.removeRun(i);
//				}
//			}
//		}
//	}
//
//	private void replaceValues(XWPFParagraph paragraph, Map<String, String> valuesToReplace) {
//		List<XWPFRun> runs = paragraph.getRuns();
//		if (!CollectionUtils.isEmpty(runs)) {
//
//			XWPFRun firstRun = runs.get(0);
//			StringBuilder runText = new StringBuilder(firstRun.toString());
//
//			for (int i = 1; i <= runs.size() - 1; i++) {
//				if(runs.get(i) != null){
//					runText.append(runs.get(i).toString());
//				}
//			}
//
//			String templateText = runText.toString();
//
//			for (Map.Entry<String,String> entry : valuesToReplace.entrySet()){
//				templateText = templateText.replace(entry.getKey(), entry.getValue());
//		    }
//
//			firstRun.setText(templateText, 0);
//
//			for (int i = runs.size()-1; i > 0; i--) {
//				if(paragraph.getCTP().getHyperlinkArray().length > 0)
//					firstRun.setText(firstRun.getText(0).replace(paragraph.getCTP().getHyperlinkArray()[0].getRArray()[0].getTArray()[0].getStringValue(), ""), 0);
//				else
//					paragraph.removeRun(i);
//			}
//		}
//	}
//
//	public byte[] generatePDF(String reportName, byte[] templateFile) {
//		logger.trace("## Generating pdf file ##");
//		try {
//			WordConvertOptions opts = new WordConvertOptions();
//			WordDocument.setKey(paramsService.retrieveParameterValue(EnumTypes.ConfigParams.QOOPA_JOFFICE_LICENSE));
//			WordDocument doc = new WordDocument(templateFile, opts);
//			reportName = new StringBuilder().append(reportName).append("_").append(System.currentTimeMillis()).append(ReportExportType.PDF.toString()).toString();
//
//			ByteArrayOutputStream sOut = new ByteArrayOutputStream();
//			doc.saveAsPDF(sOut);
//			sOut.close();
//
//			return sOut.toByteArray();
//		} catch (StreamingException e) {
//			throw new ReportException("error generated PDF report stream. report:" + reportName, e);
//		} catch (Exception e) {
//			throw new ReportException("generic error generated PDF report stream. report:" + reportName, e);
//		}
//	}
//
//
//	private boolean isQrGenerationActive() {
//		return BooleanUtils.toBoolean(paramsService.retrieveParameterValue(EnumTypes.ConfigParams.DOC_QR_VERIFICATION_GENERATION_ENABLED));
//	}
//
//	@Override
//	public void prepareAccountsListForAuthorizationTemplatesConversion(AuthTemplateDetails template, List<Account> accountsSummaryDTOS) {
//		XWPFDocument xdoc = null;
//		ByteArrayOutputStream baos = null;
//		try {
//			Map<String, String> valuesToReplace = new HashMap<>();
//
//			valuesToReplace.put(ACCOUNT_NUMBER, messageSource.getMessage("content.templates.balance.acountList.accountNumber",null, LocaleContextHolder.getLocale()));
//			valuesToReplace.put(BALANCE,        messageSource.getMessage("content.templates.balance.acountList.balance",null, LocaleContextHolder.getLocale()));
//			valuesToReplace.put(BALANCE_FC,     messageSource.getMessage("content.templates.balance.acountList.balance_FC",null, LocaleContextHolder.getLocale()));
//			valuesToReplace.put(CURRENCY_CD,    messageSource.getMessage("content.templates.balance.acountList.currency_CD",null, LocaleContextHolder.getLocale()));
//			valuesToReplace.put(BALANCE_STATUS, messageSource.getMessage("content.templates.balance.acountList.balanceStatus",null, LocaleContextHolder.getLocale()));
//			valuesToReplace.put(ACCOUNT_STATUS, messageSource.getMessage("content.templates.balance.acountList.accountStatus",null, LocaleContextHolder.getLocale()));
//			valuesToReplace.put(PRODUCT_DESCR,  messageSource.getMessage("content.templates.balance.acountList.product_DESCR",null, LocaleContextHolder.getLocale()));
//
//			xdoc = new XWPFDocument(OPCPackage.open(new ByteArrayInputStream(template.getEStatementCurrentDocFile())));
//
//			for (XWPFTable tbl : xdoc.getTables()) {
//				if(tbl.getText().contains(ACCOUNT_NUMBER)) {
//					for (XWPFTableRow row : tbl.getRows()) {
//						for (XWPFTableCell cell : row.getTableCells()) {
//							for (XWPFParagraph paragraph : cell.getParagraphs()) {
//								replaceValues(paragraph, valuesToReplace);
//							}
//						}
//					}
//
//					int line = 1;
//					for (int i = 0; i < accountsSummaryDTOS.size(); i++) {
//						Account accountDetails = accountsSummaryDTOS.get(i);
//						XWPFTableRow row = tbl.insertNewTableRow(line);
//
//						// Account Number
//						row.addNewTableCell().setText(accountDetails.getAccountNumber() != null ? accountDetails.getAccountNumber() : "");
//
//						if(Constants.SAR.getCurrencyCode().equals(accountDetails.getBalance().getCurrencyUnit().getCurrencyCode())){
//							// Balance - If the Currency_CD is SAR, then this field should have a value of the balance.
//							row.addNewTableCell().setText(accountDetails.getBalance().getAmount().toString() != null ? accountDetails.getBalance().getAmount().toString() : "");
//
//							// Balance_FC - If the Currency_CD is SAR, then the value of this field should be 0.00
//							row.addNewTableCell().setText("0.00");
//						} else {
//							// Balance - If the Currency_CD is non SAR, then the channel should call InitiateFXDeal and pass the actual balance in cross currency to have the conversion rate in SAR and fill this field with the amount equal to SAR.
//							String balance_str = "";
//							BigMoney balance = treasuryService.convertCurrency(accountDetails.getAccountNumber(), accountDetails.getBalance().getCurrencyUnit(), accountDetails.getBalance().getAmount(), CurrencyUnit.getInstance("SAR"));
//							if(balance != null){
//								balance_str = String.valueOf(balance.getAmount());
//							}
//							row.addNewTableCell().setText(balance_str);
//
//							// Balance_FC - If the Currency_CD is non SAR, then this field should have a value of the balance.
//							row.addNewTableCell().setText(accountDetails.getBalance().getAmount().toString() != null ? accountDetails.getBalance().getAmount().toString() : "");
//						}
//
//						// Currency_CD
//						row.addNewTableCell().setText(accountDetails.getBalance().getCurrencyUnit().getCurrencyCode() != null ? accountDetails.getBalance().getCurrencyUnit().getCurrencyCode() : "");
//
//						// Balance Status
//						String CR_DR = "";
//						if(accountDetails.getBalance() != null){
//							if(accountDetails.getBalance().getAmount().compareTo(BigDecimal.ZERO) > 0){
//								CR_DR = messageSource.getMessage("content.templates.balance.cr", null, LocaleContextHolder.getLocale());
//							} else {
//								CR_DR = messageSource.getMessage("content.templates.balance.dr", null, LocaleContextHolder.getLocale());
//							}
//						}
//						row.addNewTableCell().setText(CR_DR);
//
//						// Account Status - status
//						row.addNewTableCell().setText(accountDetails.getStatus().name() != null ? accountDetails.getStatus().name() : "");
//
//						// Product DESCR - typeDesc
//						row.addNewTableCell().setText(accountDetails.getTypeDesc() != null ? accountDetails.getTypeDesc() : "");
//
//						line++;
//					}
//				}
//			}
//			baos = new ByteArrayOutputStream();
//			xdoc.write(baos);
//			template.setEStatementCurrentDocFileRawData(baos.toByteArray());
//		} catch (Exception e) {
//			logger.error("prepareAccountsListForAuthorizationTemplatesConversion -- error: {}",  e);
//		} finally {
//			try {
//				if(baos != null) {
//					baos.close();
//				}
//			} catch (IOException e) {
//				logger.error("prepareAccountsListForAuthorizationTemplatesConversion -- error: {}",  e);
//			}
//		}
//	}

}
