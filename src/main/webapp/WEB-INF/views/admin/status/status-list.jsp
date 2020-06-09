<%@ page pageEncoding="ISO-8859-1"  contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@taglib prefix="defaultTemplate" tagdir="/WEB-INF/tags"%>
. 
<defaultTemplate:defaultDecorator>
<jsp:attribute name="title">SR</jsp:attribute>
<jsp:body>

<div id="page_content_inner">
      <h3 class="heading_a uk-margin-bottom">Sort products by name:</h3>

      <ul id="products_sort" class="uk-subnav uk-subnav-pill">
          <li data-uk-sort="product-name:asc"><a href="#">Ascending</a></li>
          <li data-uk-sort="product-name:desc"><a href="#">Descending</a></li>
      </ul>

      <div class="uk-grid-width-small-1-2 uk-grid-width-medium-1-3 uk-grid-width-large-1-4 hierarchical_show" data-uk-grid="{gutter: 20, controls: '#products_sort'}" data-show-delay="280">
          <div data-product-name="Ipsum ea doloribus.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 555.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Ipsum ea doloribus.
                          <span class="sub-heading">SKU: 128985</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Illo est.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 571.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_3.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Illo est.
                          <span class="sub-heading">SKU: 107235</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Provident ad blanditiis.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 575.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Provident ad blanditiis.
                          <span class="sub-heading">SKU: 128031</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Fugit sit.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 465.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_3.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Fugit sit.
                          <span class="sub-heading">SKU: 126187</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Necessitatibus accusamus quasi.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 529.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_3.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Necessitatibus accusamus quasi.
                          <span class="sub-heading">SKU: 109329</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Neque quam.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 583.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Neque quam.
                          <span class="sub-heading">SKU: 140832</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Voluptatem error.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 548.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_2.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Voluptatem error.
                          <span class="sub-heading">SKU: 141888</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Unde quia.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 553.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Unde quia.
                          <span class="sub-heading">SKU: 101239</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Quos sunt.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 502.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_1.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Quos sunt.
                          <span class="sub-heading">SKU: 135064</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Vel reiciendis.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 574.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_3.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Vel reiciendis.
                          <span class="sub-heading">SKU: 138841</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Et voluptatem molestiae.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 468.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_1.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Et voluptatem molestiae.
                          <span class="sub-heading">SKU: 189090</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Sunt molestiae.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 524.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_3.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Sunt molestiae.
                          <span class="sub-heading">SKU: 176258</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Eum officiis.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 480.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Eum officiis.
                          <span class="sub-heading">SKU: 144458</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Ea rerum.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 538.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_2.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Ea rerum.
                          <span class="sub-heading">SKU: 143534</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Consequuntur fugit.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 549.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_1.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Consequuntur fugit.
                          <span class="sub-heading">SKU: 186815</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Aperiam harum.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 549.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Aperiam harum.
                          <span class="sub-heading">SKU: 185247</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Sed dolorum ad.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 525.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Sed dolorum ad.
                          <span class="sub-heading">SKU: 159213</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Incidunt rerum ipsam.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 508.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Incidunt rerum ipsam.
                          <span class="sub-heading">SKU: 177737</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Facere perspiciatis architecto.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 542.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_2.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Facere perspiciatis architecto.
                          <span class="sub-heading">SKU: 113667</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Officia perspiciatis corporis.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 503.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Officia perspiciatis corporis.
                          <span class="sub-heading">SKU: 111604</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Quidem iusto.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 493.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Quidem iusto.
                          <span class="sub-heading">SKU: 138700</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Placeat ut.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 598.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_3.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Placeat ut.
                          <span class="sub-heading">SKU: 138788</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Cum corrupti alias.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 493.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge_3.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Cum corrupti alias.
                          <span class="sub-heading">SKU: 156170</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
          <div data-product-name="Dolores id.">
              <div class="md-card md-card-hover-img">
                  <div class="md-card-head uk-text-center uk-position-relative">
                      <div class="uk-badge uk-badge-danger uk-position-absolute uk-position-top-left uk-margin-left uk-margin-top">$ 535.00</div>
                      <img class="md-card-head-img" src="assets/img/ecommerce/s6_edge.jpg" alt=""/>
                  </div>
                  <div class="md-card-content">
                      <h4 class="heading_c uk-margin-bottom">
                          Dolores id.
                          <span class="sub-heading">SKU: 117636</span>
                      </h4>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aliquid autem cupiditate harum illum&hellip;</p>
                      <a class="md-btn md-btn-small" href="ecommerce_product_details.html">More</a>
                  </div>
              </div>
          </div>
      </div>
 </div>
 
</jsp:body>
</defaultTemplate:defaultDecorator>