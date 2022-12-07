package kr.or.onepizza;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

public class PizzaFactory extends OwnerSystem {
	private Queue<Pizza> queue;
	private Queue<Calendar> fQueue; // ���ڰ� ������ �� �ð�
	private Calendar calendar;

	public PizzaFactory() {
		queue = new LinkedList<Pizza>();
		fQueue = new LinkedList<Calendar>();
	}

	// ���� ���� ��⿭�� �ֱ�
	public boolean pizzaMap(Map<String, Integer> pizzaList) {

		int time = 3;
		boolean returnTemp = true;

		for (String pizza : pizzaList.keySet()) {
			for (int i = 0; i < pizzaList.get(pizza); i++) {
				// �ڽ� ������
				if (box < 1) {
					System.out.println("��� �����մϴ�.");
					returnTemp = false;
					break;
				}
				if (dough < 1 && dough < i) {
					System.out.println("��� �����մϴ�.");
					returnTemp = false;
					break;
				}

				// �⺻��� ����x ���ں� ���x
				if (tomatoSauce > 0 || dough > 0 || cheese > 0) {
					if (pizza.equals("PepperoniPizza") && pepperoni < 1) {
						System.out.println("���۷δ� ���ڴ� ��� �������� ���� ǰ���Դϴ�");
						continue;
					} else if (pizza.equals("SweetPotatoPizza") && (sweetPotato < 1 || onion < 1)) {
						System.out.println("���� ���ڴ� ��� �������� ���� ǰ���Դϴ�");
						continue;
					} else if (pizza.equals("ShrimpPizza") && (shrimp < 1 || bacon < 1)) {
						System.out.println("������ ���ڴ� ��� �������� ���� ǰ���Դϴ�");
						continue;
					}

					// ���� ������ �Ϸ�� ���
					if (!queue.isEmpty()) {
						calendar = Calendar.getInstance(Locale.KOREA);
						while (true) {
							if (calendar.after(fQueue.peek())) {
								fQueue.poll();
								queue.poll();

							} else {
								break;
							}
						}
					}

					// ���� ����ŷ(����� ���� �����ϰ�)
					Pizza makePizza = getPizza(pizza);
					if (makePizza != null) {
						time += 3;
						makePizza.createPizza(pizza);
						queue.offer(makePizza);

						calendar = Calendar.getInstance();
						calendar.add(Calendar.MINUTE, time);
						fQueue.offer(calendar); // ���ڰ� ���� ���� ��⿭���� ���;��ϴ� �ð�
					}

				} else {
					System.out.println("�⺻��� �������� ���� �� �޴� ǰ����Ȳ�Դϴ�.\n"); // �⺻��� : ����, �ҽ�, ġ��
				}
			}
			if (!returnTemp) {
				break;
			}
		}
		if (returnTemp) {
			System.out.println("���� ��⿭�� �߰�, ���� ��� ���� ���� : " + fQueue.size() + "��� �ð� : " + fQueue.size() * 3 + "��\n");
		}

		return returnTemp;
	}

	// ���� ����
	private Pizza getPizza(String pizzaName) {
		return "���۷δ� ����".equals(pizzaName) ? new PepperoniPizza()
				: "���� ����".equals(pizzaName) ? new SweetPotatoPizza()
						: "������ ����".equals(pizzaName) ? new ShrimpPizza() : null;
	}

	// ���� ���ð� ���
	public void timePrint() {
		int time = fQueue.size() * 10; // 10��
		System.out.println("���� ���ð��� : " + time + "�� �Դϴ�.\n"); // ���� �ޱ���� ���� �ð� ���
	}

}