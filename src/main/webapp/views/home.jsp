<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/assets/web" var="url"></c:url>

        <div class="app__container">
            <div class="grid">
                <div class="grid__row app__container">
                    <div class="grid__col2">
                        <nav class="category">
                            <ul class="category-list">
                                <h3 class="category__heading">
                                Danh mục
                                    
                                </h3>
                                
                                 <c:forEach items="${CategoryListAll}" var="categoryItem"> 

                                <li class="category-item ">
                                   <a href="home?typeProduce=${tagactiveTypeProduce}&cid=0${categoryItem.cid }" class="category-item__link"> <i style="color: #EE4D2D; padding-right: 8px;"   class=" ${tagactive == categoryItem.cid ? "fas fa-star" :"far fa-star"} "></i> ${categoryItem.cname}</a>
                                </li>

                               </c:forEach>

                                

                            </ul>
                        </nav>
                    </div>

                    <div class="grid__col10">
                        <div class="home-filter">
                            <span class="home-filter__label">Sắp xếp theo</span>
                            
                            <a href="home?typeProduce=0&cid=${tagactive}" class="home--filter__btn btn ${tagactiveTypeProduce == 0 ? "btn--primary" :""}">Phổ biết</a>
                            <a href="home?typeProduce=1&cid=${tagactive}" class="home--filter__btn btn ${tagactiveTypeProduce == 1 ? "btn--primary" :""}">Mới nhất</a>
                            <a href="home?typeProduce=2&cid=${tagactive}" class="home--filter__btn btn ${tagactiveTypeProduce == 2 ? "btn--primary" :""}">Bán chạy</a>

                            <div class="selection-input">
                                <span class="select-input__lable">Giá <span style="color: #EE4D2D;">${tagactiveTypeProduce == 3 ? ": Thấp đến cao" :""} ${tagactiveTypeProduce == 4 ? ": Cao đến thấp" :""}</span> </span>

                                <i class="select-input__icon fas fa-chevron-down"></i>

                                <ul class="select-input__list">
                                    <li class="select-input__item">
                                        <a href="home?typeProduce=3&cid=${tagactive}" class="select-input__link">Giá: Thấp đến cao</a>
                                    </li>

                                    <li class="select-input__item">
                                        <a href="home?typeProduce=4&cid=${tagactive}" class="select-input__link">Giá: Cao đến thấp</a>
                                    </li>
                                </ul>
                            </div>


                            <div class="home--filter__page">
                                <span class="home--filter__page-num">
                                    <span class="home--filter__page-current">1</span>/14
                                </span>

                                <div class="home--filter__page-control">
                                    <a href="" class="home--filter__page-btn home--filter__page-btn--disabled"><i class="home--filter__page-icon fas fa-chevron-left"></i></a>

                                    <a href="" class="home--filter__page-btn"><i class="home--filter__page-icon fas fa-chevron-right"></i></a>

                                </div>
                            
                            </div>

                        </div>

                        <div class="home-product">
                            <div class="grid__row">
                             <c:forEach items="${productListAll}" var="product">
                                <div class="grid__col2-4">
                              
                              
                                    <a href="productdetail?pid=${product.pid}&cid=${product.cid}" class="home-product-item">
                                    <c:url value="/image?fname=${product.imageLink}" var="imgUrl"></c:url>
												<%-- <td><img height="150" width="200" src="${imgUrl}" /></td> --%>
                                        <div class="home-product-item__img" style="background-image: url(${imgUrl});">
                                        </div>
                                        <h4 class="home-product-item__name">
                                            <span style= "font-weight: bold;"> ${product.pname} </span> ${product.pdescription}
                                        </h4>
                                        <div class="home-product-item__price">
                                            <span class="home-product-item__price-old">
                                                ${product.price}
                                            </span>
                                            <span class="home-product-item__price-current">
                                                ${Integer.valueOf(product.price - product.price*product.discount/100)}
                                            </span>
                                        </div>
                                        <div class="home-product-item__action">
                                            <span class="home-product-item__like home-product-item__like--like">
                                                <i class="home-product-item__like-icon-empty far fa-heart"></i>
                                                <i class="home-product-item__like-icon-fill fas fa-heart"></i>
                                            </span>
                                            <div class="home-product-item__rating">
                                                <i class="home-product-item__star-gold fas fa-star"></i>
                                                <i class="home-product-item__star-gold fas fa-star"></i>
                                                <i class="home-product-item__star-gold fas fa-star"></i>
                                                <i class="home-product-item__star-gold fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                            </div>
                                            <span class="home-product-item__sold">${product.daban} đã bán</span>

                                        </div>
                                        <div class="home-product-item__origin">
                                            <span class="home-product-item__brand">Whoo</span>
                                            <div class="home-product-item__origin-name">Japan</div>
                                        </div>

                                        <div class="home-product-item__favorite">
                                            <i class="fas fa-check"></i>
                                            <span>Yêu thích</span>
                                
                                        </div>

                                        <div class="home-product-item__sale-off">
                                            <span class="home-product-item__sale-off-percent">${product.discount}%</span>
                                            <span class="home-product-item__sale-off-label">GIẢM</span>
                                        </div>

                                    </a>
                                </div>
                              </c:forEach> 
                             


                            </div>
                        </div>

                        <ul class="pagination pagination-item__pagination">
                        	<c:if test="${tag>1}">
                            <li class="pagination-item">
                                <a href="home?cid=${tagactive}&index=${tag-1}" class="pagination-item__link">
                                    <i class="pagination-item__icon fas fa-angle-left">
                                    </i>
                                </a>
                            </li>
                            </c:if>
							<c:forEach begin="1" end="${endP}" var="i">
								<%-- <li class="pagination-item pagination-item--active" ${tag==i ? "active":"" }">
                                <a href="home?cid=${tagactive}&index=${i}" class="pagination-item__link">
                                    ${i }
                                </a>
                            </li> --%>
                            <li class="page-item ${tag==i ? "active":"" }"><a class="page-link" href="home?cid=${tagactive}&index=${i}">${i}</a></li>
							</c:forEach>
							<c:if test="${tag<endP}">
								<li class="pagination-item">
                                <a href="#" class="pagination-item__link">
                                    <i class="pagination-item__icon fas fa-angle-right">

                                    </i>
                                </a>
                            </li>
							</c:if>

                        <%-- </ul>
                        <ul class="pagination">
                        <c:if test="${tag>1}">
                            <li class="page-item">
                                <a class="page-link" href="home?cid=${tagactive}&index=${tag-1}">Previous</a>
                            </li>
                            </c:if>
                            <c:forEach begin="1" end="${endP}" var="i">
                             <li class="page-item ${tag==i ? "active":"" }"><a class="page-link" href="home?cid=${tagactive}&index=${i}"">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag<endP}">
                            <li class="page-item">
                                <a class="page-link" href="home?cid=${tagactive}&index=${tag+1}">Next</a>
                            </li>
                            </c:if>
                        </ul> --%>



                    </div>

                </div>



            </div>

        </div>