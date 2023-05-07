package yandex_2.B._4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class D {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        Map<String, Integer> partyVotesStorage = new HashMap<>();

        AtomicInteger countVotes = new AtomicInteger();
        strings.forEach(str -> {
            String[] s = str.split(" ");
            int countVote = Integer.parseInt(s[s.length - 1]);
            StringBuilder partyName = new StringBuilder();
            IntStream.range(0, s.length - 1).forEach(i -> {
                partyName.append(s[i]).append(" ");
            });
            countVotes.addAndGet(countVote);
            partyVotesStorage.merge(partyName.toString().trim(), countVote, Integer::sum);
        });

        int firstElectoralNumber = countVotes.get() / 450;
        AtomicInteger countVoteDistribution = new AtomicInteger();
        Map<String, Integer> voteStorage = new HashMap<>();
        partyVotesStorage.forEach((k, v) -> {
            if (firstElectoralNumber == 0) {
                voteStorage.put(k, 0);
            } else {
                int countPartyVotes = v / firstElectoralNumber;
                countVoteDistribution.addAndGet(countPartyVotes);
                voteStorage.put(k, countPartyVotes);
            }
        });

        if (countVoteDistribution.get() < 450) {
            distributionRoundTwo(voteStorage, 450 - countVoteDistribution.get());
        }
        voteStorage.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private static void distributionRoundTwo(Map<String, Integer> voteStorage, int reminderVote) {

    }
}
