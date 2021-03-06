package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

//Repository indica que a classe é um repositorio
@Repository
//O Spring Data JPA utiliza interfaces para fazer comunicação
//Para que a interface funcione integrado com Spring Data
//é necessário extender a interface JPARepository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Cacheable("books")
	List<Pedido> findByStatus(StatusPedido status, Pageable sort);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> findByStatusAndUser(@Param("status") StatusPedido status, @Param("username") String username);

	// atributo necessário para a classe, gerenciado pelo Spring e injetado na classe
	//como é um subprojeto JPA ele sabe utilizar o EntityManager
	//@PersistenceContext
	//private EntityManager em;

	//Quando o Spring Data vê um método chamado findAll que recupera uma lista de pedidos
	//ele sabe qual tipo de query deve fazer
	//Implementase o método de acrordo com seu nome
	//Esse método não é necessário pois ele já é herdado da interface JPARepository
	//public List<Pedido> findAll();
}
