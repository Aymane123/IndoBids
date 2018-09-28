class Offer {
  offer_id: number;
  id: String;
  url: String
  price: number;
  oldprice: number;
  currencyId: String;
  categoryId: String;
  delivery: boolean;
  name: String;
  vendor: String;
  vendorCode: String;
  model: String;
  description: String;
  available: String;
  pictures: Picture[];
  offerParameters: OfferParameter[];
}
