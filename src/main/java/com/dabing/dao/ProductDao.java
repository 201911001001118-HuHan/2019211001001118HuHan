package com.dabing.dao;

import com.dabing.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            pt.setBinaryStream(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "DELETE FROM product WHERE productId=?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        return ps.executeUpdate();
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "UPDATE product SET productName=?,productDescription=?,picture=?,price=?,categoryId=? WHERE productId=?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, instance.getProductName());
        ps.setString(2, instance.getProductDescription());
        ps.setBinaryStream(3, instance.getPicture());
        ps.setDouble(4, instance.getPrice());
        ps.setInt(5,instance.getCategoryId());
        ps.setInt(6, instance.getProductId());
        return  ps.executeUpdate();
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * FROM product WHERE productId = ? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        if(resultSet.next())
        {
            product = new Product();
            product.setProductId(productId);
            product.setProductName(resultSet.getString("productName"));
            product.setProductDescription(resultSet.getString("productDescription"));
            product.setPicture(resultSet.getBinaryStream("picture"));
            product.setCategoryId(resultSet.getInt("categoryId"));
            product.setPrice(resultSet.getDouble("price"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        return null;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        return null;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
}
