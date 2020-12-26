package com.example.sits_313_android;

public class Story {

    private Situation start_story;
    public Situation current_situation;
    MainActivity activity;

    Story(MainActivity activity) {
        this.activity = activity;
        start_story = new Situation(
                "--+++==========+++--\n",
                "Начнём?\n\n--+++==========+++--",
                1, new String[]{"да"}, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "первая сделка (Windows)",
                "Только вы начали работать и тут же удача! Вы нашли клиента и продаете ему "
                        + "партию ПО MS Windows. Ему в принципе достаточно взять 100 коробок версии HOME.",
                3, new String[]{
                    "у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок ULTIMATE по 50тр",
                    "чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок PRO по 10тр",
                    "как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр"},
                0, 0, 0);
        start_story.direction[0].direction[0] = new Situation(
                "корпоратив",
                "Неудачное начало, ну что ж, сегодня в конторе корпоратив! "
                    + "Познакомлюсь с коллегами, людей так сказать посмотрю, себя покажу.",
                1, new String[]{
                        "продолжить"},
                0, -10, -10);
            start_story.direction[0].direction[0].direction[0] = new Situation(
                    "корпоратив",
                    "На следующий день к вам подходит начальник и сообщает, что клиент недоволен!",
                    3, new String[]{
                        "сказать, что это случайность, пообещать быть внимательнее",
                        "извиниться, сказать, что такое больше не повториться",
                        "промолчать"
                    },0, -10, -10);
                start_story.direction[0].direction[0].direction[0].direction[0] = new Situation(
                        "случайная ошибка",
                        "Начальство вам не доверяет. Будьте внимательнее!",
                        -1, 0, 0);
                start_story.direction[0].direction[0].direction[0].direction[1] = new Situation(
                        "прошу прощения",
                        "\"Извиняться перед клиентом будете!\" \n Ваш авторитет упал.",
                        0, 0, -5);
                start_story.direction[0].direction[0].direction[0].direction[2] = new Situation(
                        "гнев начальства",
                        "Начальник долго вас отчитывал, а работа сама не делается! Вы упустили крупную сделку...",
                        0, -20, 0);
        start_story.direction[0].direction[1] = new Situation(
                "совещание, босс доволен",
                "Сегодня будет совещание, меня неожиданно вызвали, есть сведения, что босс доволен сегодняшней сделкой.\nВам предложили поучавствовать в новом большом проекте Корпорации! Согласитесь?",
                2, new String[]{
                        "Да, конечно! Всегда мечтал работать в таком проекте!",
                        "Нет, я только устроился на работу, ещё не привык к обстановке."
                }, 1, 100, 0);
            start_story.direction[0].direction[1].direction[0] = new Situation(
                    "крупный проект",
                    "Эта работа оказалась слишком сложной для вас! Нужно сначала набраться опыта, поработать в компании подольше.",
                    0, -30, -1);
            start_story.direction[0].direction[1].direction[1] = new Situation(
                    "это не для меня",
                    "И правильно! Проект слишком сложный. Лучше поработать спокойно. Вы хорошо продвинулись на своей должности!",
                    5, 50, 5);
        start_story.direction[0].direction[2] = new Situation(
                "мой первый лояльный клиент",
                "Мой первый клиент доволен скоростью и качеством моей работы. Сейчас мне звонил лично директор компании, сообщил, что скоро состоится еще более крупная сделка, и он хотел, чтобы по ней работал именно я!\nСогласитесь?",
                2, new String[]{
                        "Да!",
                        "Нет, я не готов принять на себя такую ответственность.",
                }, 0, 0, 1);
            start_story.direction[0].direction[2].direction[0] = new Situation(
                    "новая сделка",
                    "Корпорация продаёт клиенту 50 коробок только что прибывшего на склад товара. Вы должны проследить, чтобы клиент получил ящики в сохранности. Товар нужно доставить завтра. Вы поедете в грузовике вместе с товаром или останетесь в офисе и будете поддерживать связь с курьером и покупателем?",
                    2, new String[]{
                            "Поеду с товаром, лучше самому проконтролировать всё.",
                            "Останусь в офисе, зачем целый день разъезжать по городу, если есть телефон?"
                    },1, 100, 0);
                start_story.direction[0].direction[2].direction[0].direction[0] = new Situation(
                        "доставка товара",
                        "Вы поехали в грузовике. К сожалению, в этот день было очень холодно и вы заболели. Пришлось потратить часть заработанных денег на лекарства. Зато клиент очень доволен, вы получили повышение!",
                        1, -30, 5);
                start_story.direction[0].direction[2].direction[0].direction[1] = new Situation(
                        "у телефона",
                        "Вы не захотели ехать в грузовике. Эта ужасная тряска! Да и прогноз погоды оставляет желать лучшего..."
                        + "Всё шло хорошо, грузовик с товаром выехал со склада, но через несколько часов вам позвонил недовольный клиент. Он сказал, что товар всё ещё не привезли, хотя машина должна была приехать к нему уже полчаса назад!",
                        2, new String[]{
                                "\"Я сейчас свяжусь с нашим курьером и всё выясню!\"",
                                "\"Я ничего не знаю... Позвоните курьеру, диктую телефон ...\""
                        }, 0, 0, -1);
                    start_story.direction[0].direction[2].direction[0].direction[1].direction[0] = new Situation(
                            "проблемы на дороге",
                            "Вы позвонили курьеру, он сказал, что у него сломался навигатор, и грузовик попал в большую автомобильную пробку. Вы быстро нашли объезд и через 5 минут товар был доствлен. Хорошая работа!",
                            1, 0, 2);
                    start_story.direction[0].direction[2].direction[0].direction[1].direction[1] = new Situation(
                            "ужасный сервис",
                            "Через некоторое время клиент снова позвонил вам. Товар доставили, но покупатель был в ярости.\n"
                            + "\"Что это за обслуживание! Курьер опоздал больше чем на час! А клиенты ещё и сами должны разбираться, что происходит! Вы даже не знаете, где ваш грузовик! ...\"\n"
                            + "Вы не оправдали доверие начальства, а ведь вас собивались повысить!..",
                            -1, 0, -3);
            start_story.direction[0].direction[2].direction[1] = new Situation(
                    "отказ от сложной работы",
                    "Зря вы отказались... Ваш знакомый, тоже работавший в Корпорации, руководил этой сделкой, клиент был очень доволен, и пригласил его в свою компанию на очень интересную работу!",
                    0, 0, 0);
        current_situation = start_story;
    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            activity.console.setText("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public void resetStory() {
        this.current_situation = start_story;
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
