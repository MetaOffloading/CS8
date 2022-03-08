package com.sam.webtasks.client;

import com.sam.webtasks.basictools.Counterbalance;

public class Instructions {

	public static String Get(int index) {
		String i = "";

		switch (index) {
		case 0:
			i = "Dans cette expérience, vous aurez une tâche simple à accomplir.<br><br>"
					+ "Vous verrez plusieurs cercles jaunes à l'intérieur d'une boîte. Dans chaque cercle, il y aura un chiffre. <br><br>"
					+ "Vous pouvez les déplacer avec votre doigt. Votre tâche consiste à les faire glisser du plus petit au plus grand vers le bas de la boîte.<br><br>"
					+ "Veuillez commencer par faire glisser le 1 jusqu'en bas. Cela le fera disparaître.<br><br>"
					+ "Ensuite, faites glisser le 2 vers le bas, puis le 3, et ainsi de suite.";
			break;

		case 1:
			i="Maintenant, vous allez continuer la tâche avec d'autres cercles sur l'écran.";
			break;
			
		case 2:
			i="Maintenant, vous allez continuer la même tâche, mais parfois il y aura autre chose à faire. <br><br>"
					+ "De même qu'il faut faire glisser chaque cercle un par un "
					+ "vers le bas de l'écran, il vous sera demandé de faire glisser un ou plusieurs "
					+ "cercles vers une autre partie de la boîte. Par exemple, on peut vous dire que vous devez faire glisser le numéro 5 "
					+ "vers la gauche de la boîte plutôt que vers le bas.<br><br>"
					+ "Vous pourrez toujours faire glisser n'importe quel cercle vers le bas de la boîte, mais vous devrez essayer de "
					+ "vous rappeler de faire glisser ces cercles spéciaux à l'endroit indiqué.";
			break;

		case 3:
			i="Maintenant, vous allez refaire la tâche, mais cette fois, il y aura trois cercles spéciaux à retenir.";
			break;
			
		case 4:
			i="Maintenant vous allez continuer avec la même tâche, mais parfois vous serez interrompus par "
					+"une question d'arithmétique. Vous devrez répondre à la question afin de pouvoir continuer l'autre tâche.";
			break;
			
		case 5:
			i="Certaines personnes trouvent que cela aide de glisser "
					+ "les cercles spéciaux près du bord de la boîte pour les aider à se souvenir.<br><br>"
					+ "Par exemple, si vous deviez vous rappeler de faire glisser 5 vers la gauche de la boîte, "
					+ "vous pourriez le faire glisser près de la gauche au début, avant de faire glisser le 1. "
					+ "Ensuite, quand vous arriverez à 5, son emplacement vous rappellera "
					+ "ce qu'il faut faire. Vous pouvez utiliser cette stratégie si vous le souhaitez, mais "
					+ "c'est à vous de choisir.<br><br> "
					+ "Cliquez en dessous pour continuer.";
			break;
			
		case 6:
			i = "Maintenant, l'expérience va commencer réellement.<br><br> "
					+ "Vous pouvez choisir d'utiliser la stratégie consistant à placer les cercles spéciaux "
					+ "au bord de la boîte comme rappels ou simplement utiliser votre propre mémoire sans fixer de rappels.<br><br>"
					+ "Vous devez vous sentir libre d'effectuer la tâche comme vous le souhaitez. C'est vous qui décidez.<br><br> "
					+ "Veuillez cliquer en dessous pour continuer.";
			break;
			
		case 7:
			i = "Maintenant, l'expérience va commencer réellement.<br><br>"
					+ "Pour cette partie de l'expérience, vous devrez utiliser votre mémoire pour effectuer la tâche. "
					+ "Vous ne pourrez pas placer les cercles spéciaux au bord de la boîte comme rappels. "
					+ "Utilisez votre mémoire et faites de votre mieux.<br><br> "
					+ "Veuillez cliquer en dessous pour continuer.";
			break;
			
		case 8:
			i = "A partir de ce moment, vous ne pourrez plus placer de cercles spéciaux au bord de la boîte comme rappels.<br><br>"
					+ "Utilisez votre mémoire et faites de votre mieux.<br><br> "
					+ "Veuillez cliquer en dessous pour continuer.";
			break;
			
		case 9:
			i="Pour le reste de l'expérience, il vous est possible de choisir d'utiliser des rappels ou non. C'est-à-dire que "
					+ "vous pouvez choisir d'utiliser la stratégie consistant à placer les cercles spéciaux "
					+ "au bord de la boîte comme rappels ou utilisez simplement votre propre mémoire sans définir de rappels.<br><br>"
					+ "Vous devez vous sentir libre d'effectuer la tâche comme vous le souhaitez. C'est vous qui décidez.<br><br>"
					+ "Veuillez cliquer en dessous pour continuer.";
			break;
			
		case 10:
			i="TEST ";
			break;
		}

		return (i);
	}

	public static String InfoText() {
		return ("We would like to invite you to participate in this research project. "
				+ "You should only participate if you want to; choosing not to take part "
				+ "will not disadvantage you in any way. Before you decide whether you "
				+ "want to take part, please read the following information carefully and "
				+ "discuss it with others if you wish. Ask us if there is anything that "
				+ "is not clear or you would like more information.<br><br>"
				+ "We are recruiting volunteers from the Amazon Mechanical Turk website to "
				+ "take part in an experiment aiming to improve our understanding of human "
				+ "attention and memory. Full instructions will be provided before the experiment begins. "
				+ "The experiment " + "will last approximately 40 minutes. There are no anticipated risks or "
				+ "benefits associated with participation in this study.<br><br>"
				+ "It is up to you to decide whether or not to take part. If you choose "
				+ "not to participate, you won't incur any penalties or lose any "
				+ "benefits to which you might have been entitled. However, if you do "
				+ "decide to take part, you can print out this information sheet and "
				+ "you will be asked to fill out a consent form on the next page. " + "Even after agreeing to take "
				+ "part, you can still withdraw at any time and without giving a reason. "
				+ "<br><br>All data will be collected and stored in accordance with the UK Data "
				+ "Protection Act 1998.");
	}

}
