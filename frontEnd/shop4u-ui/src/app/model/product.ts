export class Product {

  constructor(
    public productId: string,
    public sku: string,
    public title: string,
    public description: string,
    public unitPrice: number,
    public imageUrl: string,
    public active: boolean,
    public unitsInStock: number,
    public dateCreated: Date,
    public lastUpdated: Date,
    public brandId: number,
    public brandName: string,
    public categoryId: number,
    public categoryName: string,
) {}


}
