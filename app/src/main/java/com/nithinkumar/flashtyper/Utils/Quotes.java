package com.nithinkumar.flashtyper.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by nithinkumar on 6/24/17.
 */

public class Quotes {

    public List<String> quotes;
    Random mRandom = new Random();

    public Quotes()
    {
        quotes = new ArrayList<String>();

        quotes.add("A Grouch escapes so many little annoyances that it almost pays to be one.");
        quotes.add("Within a computer natural language is unnatural.");
        quotes.add("A little learning is a dangerous thing.");
        quotes.add("There really is no learning without doing.");
        quotes.add("The programmer must seek both perfection of part and adequacy of collection.");
        quotes.add("Thus, programs must be written for people to read, and only incidentally for machines to execute.");
        quotes.add("Everything should be made as simple as possible, but no simpler.");
        quotes.add("The great dividing line between success and failure can be expressed in five words: \"I did not have time.\"");
        quotes.add("When your enemy is making a very serious mistake, don't be impolite and disturb him.");
        quotes.add("A charlatan makes obscure what is clear; a thinker makes clear what is obscure.");
        quotes.add("Premature abstraction is an equally grevious sin as premature optimization.");
        quotes.add("All non-trivial abstractions, to some degree, are leaky.");
        quotes.add("He causes his sun to rise on the evil and the good, and sends rain on the righteous and the unrighteous.");
        quotes.add("A language that doesn't affect the way you think about programming, is not worth knowing.");
        quotes.add("Omit needless words.");
        quotes.add("I have never met a man so ignorant that I couldn't learn something from him");
        quotes.add("Philosophy: the finding of bad reasons for what one believes by instinct.");
        quotes.add("Fools! Don't they know that tears are a woman's most effective weapon?");
        quotes.add("The function of wisdom is to discriminate between good and evil.");
        quotes.add("If you choose not to decide, you still have made a choice.");
        quotes.add("If men could get pregnant, abortion would be a sacrament!");
        quotes.add("Admiration:Our polite recognition of another's resemblance to ourselves.");
        quotes.add("How long a minute is depends on which side of the bathroom door you're on.");
        quotes.add("If you view your problem closely enough you will recognize yourself as part of the problem.");
        quotes.add("The past always looks better than it was.  It's only pleasant because it isn't here.");
        quotes.add("Lie: A very poor substitute for the truth, but the only one discovered to date.");
        quotes.add("Real Programmers don't comment their code.  If it was hard to write, it should be hard to understand.");
        quotes.add("Anarchy may not be the best form of government, but it's better than no government at all.");
        quotes.add("Don't worry over what other people are thinking about you. They're too busy worrying over what you are thinking about them.");
        quotes.add("If it is true that there is always more than one way of construing a text, it is not true that all interpretations are equal.");
        quotes.add("Life moves pretty fast. If you don't stop and look around once in a while, you could miss it.");
        quotes.add("The direct pursuit of happiness is a recipe for an unhappy life.");
        quotes.add("All problems in computer science can be solved by another level of indirection.");
        quotes.add("For the things we have to learn before we can do them, we learn by doing them.");
        quotes.add("Only bad designers blame their failings on the users.");
        quotes.add("Having large case statements in an object-oriented language is a sure sign your design is flawed.");
        quotes.add("So - what are the most important problems in software engineering? I’d answer “dealing with complexity”.");
        quotes.add("The choice of the university is mostly important for the piece of paper you get at the end. The education you get depends on you.");
        quotes.add("The good thing about reinventing the wheel is that you get a round one.");
        quotes.add("It(mastering)’s knowing what you are doing.");
        quotes.add("Things which matter most must never be at the mercy of things which matter least.");
        quotes.add("Don't have good ideas if you aren't willing to be responsible for them.");
        quotes.add("If we wish to count lines of code, we should not regard them as lines produced but as lines spent.");
        quotes.add("The most damaging phrase in the language is, It's always been done that way.");
        quotes.add("The only thing a man should ever be 100% convinced of is his own ignorance.");
        quotes.add("In theory, there’s no difference between theory and practice. But in practice, there is.");
        quotes.add("J'ai toujours préféré la folie des passions à la sagesse de l'indifférence.");
        quotes.add("Ils ne sont pas forts parce qu'ils sont forts. Ils sont forts parce que nous sommes faibles.");
        quotes.add("It is better to be quiet and thought a fool than to open your mouth and remove all doubt.");
        quotes.add("Simplicity means the achievement of maximum effect with minimum means.");
        quotes.add("Normality is the route to nowhere.");
        quotes.add("The problem is that Microsoft just has no taste. And I don't mean that in a small way, I mean that in a big way.");
        quotes.add("Do you want to sell sugared water all your life or do you want to change the world?");
        quotes.add("Good work is no done by ‘humble’ men.");
        quotes.add("Remember, always be yourself ... unless you suck!");
        quotes.add("The definition of insanity is doing the same thing over and over again and expecting different results.");
        quotes.add("The general principle for complexity design is this: Think locally, act locally.");
        quotes.add("Two people should stay together if together they are better people than they would be individually.");
        quotes.add("Whatever is worth doing at all, is worth doing well.");
        quotes.add("The best is the enemy of the good.");

    }

    public String getQuote()
    {
        int pos = mRandom.nextInt(60);
        return quotes.get(pos);
    }

}
