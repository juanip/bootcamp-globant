-- phpMyAdmin SQL Dump
-- version 4.2.6deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-01-2015 a las 13:25:27
-- Versión del servidor: 5.5.40-0ubuntu1
-- Versión de PHP: 5.5.12-2ubuntu4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `shopping_cart`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id_category` int(10) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `client_id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birth_date` date NOT NULL,
  `user` varchar(25) NOT NULL,
  `pass` varchar(25) NOT NULL,
  `id_shopping_cart` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credit_cards`
--

CREATE TABLE IF NOT EXISTS `credit_cards` (
  `id_credit_card` int(10) NOT NULL,
  `number` varchar(16) NOT NULL,
  `security_code` varchar(3) NOT NULL,
  `name` varchar(25) NOT NULL,
  `id_client` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item_lines`
--

CREATE TABLE IF NOT EXISTS `item_lines` (
  `id_item_line` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `id_order` int(10) DEFAULT NULL,
  `id_shopping_cart` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int(10) NOT NULL,
  `date` date NOT NULL,
  `total` double NOT NULL,
  `client_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `id_payment` int(10) NOT NULL,
  `id_order` int(10) NOT NULL,
  `date` date NOT NULL,
  `amount` double NOT NULL,
  `id_credit_card` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id_product` int(10) NOT NULL,
  `description` varchar(150) NOT NULL,
  `price` double NOT NULL,
  `id_category` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sessions`
--

CREATE TABLE IF NOT EXISTS `sessions` (
  `id_session` int(10) NOT NULL,
  `expiration` date NOT NULL,
  `id_client` int(10) NOT NULL,
  `token` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shopping_carts`
--

CREATE TABLE IF NOT EXISTS `shopping_carts` (
  `id_shopping_cart` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
 ADD PRIMARY KEY (`id_category`);

--
-- Indices de la tabla `clients`
--
ALTER TABLE `clients`
 ADD PRIMARY KEY (`client_id`), ADD KEY `id_shopping_cart` (`id_shopping_cart`);

--
-- Indices de la tabla `credit_cards`
--
ALTER TABLE `credit_cards`
 ADD PRIMARY KEY (`id_credit_card`), ADD KEY `id_client` (`id_client`);

--
-- Indices de la tabla `item_lines`
--
ALTER TABLE `item_lines`
 ADD PRIMARY KEY (`id_item_line`), ADD KEY `id_product` (`id_product`,`id_order`), ADD KEY `id_order` (`id_order`), ADD KEY `id_shopping_cart` (`id_shopping_cart`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
 ADD PRIMARY KEY (`order_id`), ADD KEY `client_id` (`client_id`);

--
-- Indices de la tabla `payments`
--
ALTER TABLE `payments`
 ADD PRIMARY KEY (`id_payment`,`id_order`), ADD KEY `id_credit_card` (`id_credit_card`), ADD KEY `id_order` (`id_order`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
 ADD PRIMARY KEY (`id_product`), ADD KEY `id_category` (`id_category`), ADD KEY `id_category_2` (`id_category`);

--
-- Indices de la tabla `sessions`
--
ALTER TABLE `sessions`
 ADD PRIMARY KEY (`id_session`), ADD KEY `id_client` (`id_client`,`token`);

--
-- Indices de la tabla `shopping_carts`
--
ALTER TABLE `shopping_carts`
 ADD PRIMARY KEY (`id_shopping_cart`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clients`
--
ALTER TABLE `clients`
ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`id_shopping_cart`) REFERENCES `shopping_carts` (`id_shopping_cart`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `credit_cards`
--
ALTER TABLE `credit_cards`
ADD CONSTRAINT `credit_cards_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `item_lines`
--
ALTER TABLE `item_lines`
ADD CONSTRAINT `item_lines_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `item_lines_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `item_lines_ibfk_3` FOREIGN KEY (`id_shopping_cart`) REFERENCES `shopping_carts` (`id_shopping_cart`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `orders`
--
ALTER TABLE `orders`
ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `payments`
--
ALTER TABLE `payments`
ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`id_credit_card`) REFERENCES `credit_cards` (`id_credit_card`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `products`
--
ALTER TABLE `products`
ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `categories` (`id_category`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sessions`
--
ALTER TABLE `sessions`
ADD CONSTRAINT `sessions_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
