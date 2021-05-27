package com.dabing.dao;

import com.dabing.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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
    public Product findById(Integer ProductId, Connection con) throws SQLException {
        String sql = "SELECT * FROM Product WHERE ProductId = ? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, ProductId);
        ResultSet resultSet = ps.executeQuery();
        Product product = null;
        if(resultSet.next())
        {
            product = new Product();
            product.setProductId(ProductId);
            product.setProductName(resultSet.getString("ProductName"));
            product.setProductDescription(resultSet.getString("ProductDescription"));
            product.setPicture(resultSet.getBinaryStream("picture"));
            product.setPrice(resultSet.getDouble("price"));
            product.setCategoryId(resultSet.getInt("CategoryId"));
        }
        return product;
    }
    @Override
    public List<Product> findByCategoryId(int CategoryId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where CategoryId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, CategoryId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where price between ? and ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, minPrice);
        ps.setDouble(2, maxPrice);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer ProductId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where ProductId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, ProductId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();
            if (rs.getBlob("picture") != null)
                product.setPicture((InputStream) rs.getBlob("picture"));
            productList.add(product);
        }
        return productList;
    }
    public byte[] getPictureById(int productId, Connection con) throws SQLException {
        byte[] imgByte = null;
        String sql = "select picture from Product where productId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Blob blob = rs.getBlob("picture");
            imgByte = ((Blob) blob).getBytes(1, (int) blob.length());
        }
        return imgByte;
    }
}
