package pochacm.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pochacm.dao.face.InvoiceDao;
import pochacm.dto.Invoice;
import pochacm.dto.InvoiceItem;
import pochacm.dto.Item;
import pochacm.dto.Brand;
import pochacm.dto.Category;
import pochacm.dto.OrderUnit;
import pochacm.dto.Paging;
import pochacm.dto.PrimaryUnit;
import pochacm.dto.Recipe;
import pochacm.dto.SecondaryUnit;
import pochacm.dto.Supplier;
import pochacm.service.face.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Autowired InvoiceDao invoiceDao;
	
	//invoice Paging
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Paging getInvoicePaging(Paging paging) {
		//logger index
		int idx = 0;
		logger.info("#{}. getInvoicePaging", idx++);
		logger.info("#{}. paging : {}", idx++, paging);
		
		int page = 0;
		
		if( Integer.toString(paging.getCurPage()) != null && !"".equals(paging.getCurPage()) ) {
			page = paging.getCurPage();
			logger.info("#{}. paging.getCurPage() : {}", idx++, paging.getCurPage());
		} else {
			logger.warn("there is no paging.getCurPage() or null value");
		}
		
		String keyword = paging.getKeyword();
		String category = paging.getCategory();
		
		//select total count of invoice
		int totalCount = invoiceDao.selectCntAllInvoice(paging);
		
		logger.info("#{}. totalCount : {}", idx++, totalCount);
		
		//create Paging dto - calculate paging
		Paging pagingReturn = new Paging(totalCount,page);
		
		logger.info("#{}. pagingReturn : {}", idx++, pagingReturn);
		pagingReturn.setCategory(category);
		pagingReturn.setKeyword(keyword);
		logger.info("#{}. pagingReturn : {}", idx++, pagingReturn);
		
		return pagingReturn;
	}

	//Get invoice list
	@Override
	public List<Map<String, String>> getInvoiceList(Paging paging) {
		return invoiceDao.selectAllInvoice(paging);
	}

	//view invoice detail
	@Override
	public List<Map<String, String>> selectItemsByInvoiceSerial(Invoice invoice) {
		return invoiceDao.selectItemsByInvoiceSerial(invoice);
	}	

	@Override
	public Object getItemInfoByItem(Item item) {
		return invoiceDao.selectItemInfoByItemNum(item);
	}
	
	@Override
	public List<OrderUnit> getOrderUnitList() {
		return invoiceDao.getOrderUnitList();
	}

	@Override
	public List<PrimaryUnit> getPrimaryUnitList() {
		return invoiceDao.getPrimaryUnitList();
	}

	@Override
	public List<SecondaryUnit> getSecondaryUnitList() {
		return invoiceDao.getSecondaryUnitList();
	}

	@Override
	public List<Category> getItemCategoryList() {
		return invoiceDao.getItemCategoryList();
	}

	@Override
	public Recipe getRecipeDtoWithRecipeName(String menuName) {
		//logger index
		int idx = 0;
		logger.info("#{}. getRecipeByRecipeName", idx++);
		
		Recipe recipeName = new Recipe();
		
		recipeName.setRecipeName(menuName);
		logger.info("#{}. recipeName : {}", idx++, recipeName);
		
		return recipeName;
	}

	@Override
	public List<Recipe> getMenuSearchList(Recipe recipe) {
		return invoiceDao.selectMenuSearchList(recipe);
	}

	@Override
	public void updateItemInformation(Item item) {
		invoiceDao.updateItemInformation(item);
	}

	@Override
	public void deleteInvoice(Invoice invoice) {
		invoiceDao.deleteInvoice(invoice);
	}

	@Override
	public List<Brand> selectAllBrand() {
		return invoiceDao.selectAllBrand();
	}

	@Override
	public List<Supplier> selectAllSupplier() {
		return invoiceDao.selectAllSupplier();
	}

	@Override
	public List<OrderUnit> selectAllOrderUnit() {
		return invoiceDao.selectAllOrderUnit();
	}

	@Override
	public List<Category> selectAllCategory() {
		return invoiceDao.selectAllCategory();
	}

	@Override
	public List<Item> getItemListBySearch(Item item) {
		return invoiceDao.selectItemSearchList(item);
	}

	@Override
	public Map<String, String> getInvoiceInfoByInvoiceSerial(Invoice invoice) {
		return invoiceDao.selectInvoiceInfoByInvoiceSerial(invoice);
	}

	@Override
	public void deleteInvoiceItemByNum(InvoiceItem invoiceItem) {
		invoiceDao.deleteInvoiceItemByNum(invoiceItem);
	}

	@Override
	public int countInvoiceItemByInvoiceNum(InvoiceItem invoiceItem) {
		return invoiceDao.selectInvoiceItemByInvoiceNum(invoiceItem);
	}

	@Override
	public List<Item> getItemCodeListBySearch(Item item) {
		return invoiceDao.selectItemCodeSearchList(item);
	}

	@Override
	public void insertItemInfo(Item item) {
		invoiceDao.insertItemInfo(item);
	}

	@Override
	public void insertInvoiceInfo(Invoice invoice) {
		invoiceDao.insertInvoiceInfo(invoice);
	}

	@Override
	public void insertInvoiceAndItemInfo(InvoiceItem invoiceItem) {
		invoiceDao.insertInvoiceAndItemInfo(invoiceItem);
	}

	@Override
	public String getSupplierName(Invoice invoice) {
		return invoiceDao.selectSupplierNameBySupplierNum(invoice);
	}

	@Override
	public List<Map<String, String>> getItemListByInvoiceSerial(Invoice invoice) {
		return invoiceDao.selectItemListByInvoiceSerial(invoice);
	}

	@Override
	public void updateInvoiceInfo(Invoice invoice) {
		invoiceDao.updateInvoiceInfo(invoice);
	}

	@Override
	public void insertInvoiceItemInfo(InvoiceItem invoiceItem) {
		invoiceDao.insertInvoiceItemInfo(invoiceItem);
	}

	@Override
	public void updateInvoiceItemInfo(InvoiceItem invoiceItem) {
		invoiceDao.updateInvoiceItemInfo(invoiceItem);
	}

	@Override
	public int selectInvoiceItem(InvoiceItem iin) {
		return invoiceDao.selectInvoiceItem(iin);
	}

}
