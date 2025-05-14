package org.example.ecpolyquery.query

public class GetAllCategoriesQuery {
}

public class GetPagedCategoriesQuery(val page: Int, val size: Int) {
}

public class GetAllCustomersQuery {
}

public class GetPagedCustomersQuery(val page: Int, val size: Int) {
}

public class GetAllInvoicesQuery {
}

public class GetPagedInvoicesQuery(val page: Int, val size: Int) {
}

public class GetAllOrdersQuery {
}

public class GetPagedOrdersQuery(val page: Int, val size: Int) {
}

public class GetAllOrderLinesQuery {
}

<<<<<<< Updated upstream
public class GetPagedOrderLinesQuery(val page: Int, val size: Int) {
}

public class GetAllProductsQuery {
}
=======
public class GetAllProductsQuery(
    var page: Int = 0,
    var size: Int = 10
)
>>>>>>> Stashed changes

public class GetPagedProductsQuery(val page: Int, val size: Int) {
}

public class GetAllProductSizesQuery {
}

public class GetPagedProductSizesQuery(val page: Int, val size: Int) {
}

public class GetAllPurchasesQuery {
}

public class GetPagedPurchasesQuery(val page: Int, val size: Int) {
}

public class GetAllPurchaseItemsQuery {
}

public class GetPagedPurchaseItemsQuery(val page: Int, val size: Int) {
}

public class GetAllShippingsQuery {
}

public class GetPagedShippingsQuery(val page: Int, val size: Int) {
}

public class GetAllSocialGroupsQuery {
}

public class GetPagedSocialGroupsQuery(val page: Int, val size: Int) {
}

public class GetAllStocksQuery {
}

public class GetPagedStocksQuery(val page: Int, val size: Int) {
}

public class GetAllSubcategoriesQuery {
}

<<<<<<< Updated upstream
public class GetPagedSubcategoriesQuery(val page: Int, val size: Int) {
}

public class GetAllSuppliersQuery {
}
=======
public class GetAllSuppliersQuery(
    var page: Int = 0,
    var size: Int = 10
)
>>>>>>> Stashed changes

public class GetPagedSuppliersQuery(val page: Int, val size: Int) {
}

class GetCategoryByIdQuery(val id: String)

class GetCustomerByIdQuery(val id: String)

class GetInvoiceByIdQuery(val id: String)

class GetOrderByIdQuery(val id: String)

class GetOrderLineByIdQuery(val id: String)

class GetProductByIdQuery(val id: String)

class GetProductSizeByIdQuery(val id: String)

class GetPurchaseByIdQuery(val id: String)

class GetPurchaseItemByIdQuery(val id: String)

class GetShippingByIdQuery(val id: String)

class GetSocialGroupByIdQuery(val id: String)

class GetStockByIdQuery(val id: String)

class GetSubcategoryByIdQuery(val id: String)

class GetSupplierByIdQuery(val id: String)
