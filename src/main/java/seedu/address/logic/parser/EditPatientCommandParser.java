package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BIRTHDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TREATMENT;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditPatientCommand;
import seedu.address.logic.commands.EditPatientCommand.EditPatientDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditPatientCommand object
 */
public class EditPatientCommandParser implements Parser<EditPatientCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditPatientCommand and
     * returns an EditPatientCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditPatientCommand parse(String args) throws ParseException {
        requireNonNull(args);
        try {
            String[] argsArray = args.trim().split("\\s+");
            String firstArg = argsArray[0].trim();
            long patientId = Long.parseLong(firstArg);

            ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args,
                    PREFIX_NAME,
                    PREFIX_PHONE,
                    PREFIX_BIRTHDATE,
                    PREFIX_GENDER,
                    PREFIX_REMARK,
                    PREFIX_TREATMENT,
                    PREFIX_ADDRESS,
                    PREFIX_EMAIL,
                    PREFIX_TAG);

            argMultimap.verifyNoDuplicatePrefixesFor(
                PREFIX_NAME,
                PREFIX_PHONE,
                PREFIX_BIRTHDATE,
                PREFIX_GENDER,
                PREFIX_REMARK,
                PREFIX_TREATMENT,
                PREFIX_ADDRESS,
                PREFIX_EMAIL,
                PREFIX_TAG
            );

            EditPatientDescriptor editPatientDescriptor = new EditPatientDescriptor();

            if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
                editPatientDescriptor.setName(
                    ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
            }
            if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
                editPatientDescriptor.setPhone(
                    ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
            }
            if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
                editPatientDescriptor.setEmail(
                    ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
            }
            if (argMultimap.getValue(PREFIX_ADDRESS).isPresent()) {
                editPatientDescriptor.setAddress(
                    ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get()));
            }
            if (argMultimap.getValue(PREFIX_GENDER).isPresent()) {
                editPatientDescriptor.setGender(
                    ParserUtil.parseGender(argMultimap.getValue(PREFIX_GENDER).get()));
            }

            if (argMultimap.getValue(PREFIX_BIRTHDATE).isPresent()) {
                editPatientDescriptor.setBirthdate(
                    ParserUtil.parseBirthdate(argMultimap.getValue(PREFIX_BIRTHDATE).get()));
            }

            if (argMultimap.getValue(PREFIX_REMARK).isPresent()) {
                editPatientDescriptor.setRemark(
                    ParserUtil.parseRemark(argMultimap.getValue(PREFIX_REMARK).get()));
            }

            if (argMultimap.getValue(PREFIX_TREATMENT).isPresent()) {
                editPatientDescriptor.setTreatmentName(
                    ParserUtil.parseTreatmentName(argMultimap.getValue(PREFIX_TREATMENT).get()));
            }

            parseTagsForEdit(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(
                editPatientDescriptor::setTags);

            if (!editPatientDescriptor.isAnyFieldEdited()) {
                throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
            }

            return new EditPatientCommand(patientId, editPatientDescriptor);
        } catch (NumberFormatException | NullPointerException e) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditPatientCommand.MESSAGE_USAGE), e);
        }


    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet =
            tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }

}