package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicText.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010 \u001az\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010!\u001a°\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010#\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0002\u001a\u001e\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207062\b\u00108\u001a\u0004\u0018\u000109H\u0002\u001aÂ\u0001\u0010:\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0014\u0010;\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010-2\u001c\u0010>\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010?0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006B²\u0006\n\u0010C\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "LayoutWithLinksAndInlineContent", "hasInlineContent", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "LayoutWithLinksAndInlineContent-vOo2fZY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "textModifier-cFh6CEA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "foundation_release", "displayedText"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextKt {
    /* JADX WARN: Removed duplicated region for block: B:159:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04d1  */
    /* renamed from: BasicText-VhcvRP8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m983BasicTextVhcvRP8(final java.lang.String r46, androidx.compose.ui.Modifier r47, androidx.compose.ui.text.TextStyle r48, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r49, int r50, boolean r51, int r52, int r53, androidx.compose.ui.graphics.ColorProducer r54, androidx.compose.runtime.Composer r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m983BasicTextVhcvRP8(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: BasicText-RWo7tUw, reason: not valid java name */
    public static final void m981BasicTextRWo7tUw(final AnnotatedString text, Modifier modifier, TextStyle style, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> map, ColorProducer color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TextStyle style2;
        Function1 onTextLayout;
        int i2;
        final boolean softWrap2;
        int maxLines2;
        int i3;
        int i4;
        int i5;
        int $dirty;
        int overflow2;
        int maxLines3;
        Function1 onTextLayout2;
        Composer $composer2;
        SelectionController selectionController;
        boolean softWrap3;
        int maxLines4;
        Object value$iv;
        Object value$iv2;
        TextStyle style3;
        Composer $composer3;
        Function1 onTextLayout3;
        int overflow3;
        int maxLines5;
        final int minLines2;
        final ColorProducer color2;
        final Map inlineContent;
        final int overflow4;
        final Function1 onTextLayout4;
        final TextStyle style4;
        Function0 factory$iv$iv;
        Object value$iv3;
        Composer $composer4 = $composer.startRestartGroup(-1064305212);
        ComposerKt.sourceInformation($composer4, "C(BasicText)P(9,4,8,5,6:c#ui.text.style.TextOverflow,7,2,3,1)196@9257L7:BasicText.kt#423gt5");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(text) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            style2 = style;
        } else if (($changed & 384) == 0) {
            style2 = style;
            $dirty2 |= $composer4.changed(style2) ? 256 : 128;
        } else {
            style2 = style;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            onTextLayout = function1;
        } else if (($changed & 3072) == 0) {
            onTextLayout = function1;
            $dirty2 |= $composer4.changedInstance(onTextLayout) ? 2048 : 1024;
        } else {
            onTextLayout = function1;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            i2 = overflow;
        } else if (($changed & 24576) == 0) {
            i2 = overflow;
            $dirty2 |= $composer4.changed(i2) ? 16384 : 8192;
        } else {
            i2 = overflow;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            softWrap2 = softWrap;
            $dirty2 |= $composer4.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty2 |= 1572864;
            maxLines2 = maxLines;
        } else if (($changed & 1572864) == 0) {
            maxLines2 = maxLines;
            $dirty2 |= $composer4.changed(maxLines2) ? 1048576 : 524288;
        } else {
            maxLines2 = maxLines;
        }
        int i12 = i & 128;
        if (i12 != 0) {
            $dirty2 |= 12582912;
            i3 = i12;
        } else if (($changed & 12582912) == 0) {
            i3 = i12;
            $dirty2 |= $composer4.changed(minLines) ? 8388608 : 4194304;
        } else {
            i3 = i12;
        }
        int i13 = i & 256;
        if (i13 != 0) {
            $dirty2 |= 100663296;
            i4 = i13;
        } else if (($changed & 100663296) == 0) {
            i4 = i13;
            $dirty2 |= $composer4.changedInstance(map) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i4 = i13;
        }
        int i14 = i & 512;
        if (i14 != 0) {
            $dirty2 |= 805306368;
            i5 = i14;
        } else if (($changed & 805306368) == 0) {
            i5 = i14;
            $dirty2 |= $composer4.changedInstance(color) ? 536870912 : 268435456;
        } else {
            i5 = i14;
        }
        if (($dirty2 & 306783379) == 306783378 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            minLines2 = minLines;
            color2 = color;
            $composer3 = $composer4;
            maxLines5 = maxLines2;
            style4 = style2;
            onTextLayout4 = onTextLayout;
            overflow4 = i2;
            inlineContent = map;
        } else {
            Modifier modifier3 = i6 != 0 ? Modifier.INSTANCE : modifier2;
            if (i7 != 0) {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i8 != 0) {
                onTextLayout = null;
            }
            int overflow5 = i9 != 0 ? TextOverflow.INSTANCE.m6599getClipgIe3tQ8() : i2;
            if (i10 != 0) {
                softWrap2 = true;
            }
            if (i11 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            }
            int minLines3 = i3 != 0 ? 1 : minLines;
            Map inlineContent2 = i4 != 0 ? MapsKt.emptyMap() : map;
            ColorProducer color3 = i5 != 0 ? null : color;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1064305212, $dirty2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:191)");
            }
            HeightInLinesModifierKt.validateMinMaxLines(minLines3, maxLines2);
            ProvidableCompositionLocal<SelectionRegistrar> localSelectionRegistrar = SelectionRegistrarKt.getLocalSelectionRegistrar();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer4.consume(localSelectionRegistrar);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final SelectionRegistrar selectionRegistrar = (SelectionRegistrar) objConsume;
            if (selectionRegistrar != null) {
                $composer4.startReplaceGroup(-1584983428);
                ComposerKt.sourceInformation($composer4, "198@9393L7,200@9539L69,200@9456L152,203@9617L234");
                ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer4.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onTextLayout2 = onTextLayout;
                long backgroundSelectionColor = ((SelectionColors) objConsume2).getSelectionBackgroundColor();
                $dirty = $dirty2;
                overflow2 = overflow5;
                Object[] objArr = {selectionRegistrar};
                Saver<Long, Long> saverSelectionIdSaver = selectionIdSaver(selectionRegistrar);
                ComposerKt.sourceInformationMarkerStart($composer4, -328216839, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv = $composer4.changedInstance(selectionRegistrar);
                Object value$iv4 = $composer4.rememberedValue();
                if (invalid$iv || value$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = (Function0) new Function0<Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$selectionController$selectableId$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(selectionRegistrar.nextSelectableId());
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer2 = $composer4;
                long selectableId = ((Number) RememberSaveableKt.m3772rememberSaveable(objArr, (Saver) saverSelectionIdSaver, (String) null, (Function0) value$iv4, $composer4, 0, 4)).longValue();
                ComposerKt.sourceInformationMarkerStart($composer2, -328214178, "CC(remember):BasicText.kt#9igjgp");
                int maxLines6 = maxLines2;
                boolean invalid$iv2 = $composer2.changed(selectableId) | $composer2.changed(selectionRegistrar) | $composer2.changed(backgroundSelectionColor);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv2) {
                    maxLines3 = maxLines6;
                } else {
                    maxLines3 = maxLines6;
                    if (it$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv3 = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                    selectionController = (SelectionController) value$iv3;
                }
                value$iv3 = new SelectionController(selectableId, selectionRegistrar, backgroundSelectionColor, null, 8, null);
                $composer2.updateRememberedValue(value$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
                selectionController = (SelectionController) value$iv3;
            } else {
                $dirty = $dirty2;
                overflow2 = overflow5;
                maxLines3 = maxLines2;
                onTextLayout2 = onTextLayout;
                $composer2 = $composer4;
                $composer2.startReplaceGroup(-1584467526);
                $composer2.endReplaceGroup();
                selectionController = null;
            }
            int overflow6 = overflow2;
            boolean hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(text);
            boolean hasLinks = TextAnnotatedStringNodeKt.hasLinks(text);
            if (hasInlineContent || hasLinks) {
                Composer $composer5 = $composer2;
                softWrap3 = softWrap2;
                Function1 onTextLayout5 = onTextLayout2;
                int $dirty3 = $dirty;
                maxLines4 = maxLines3;
                $composer5.startReplaceGroup(-1583391888);
                ComposerKt.sourceInformation($composer5, "241@11076L39,254@11574L7,257@11697L256,243@11125L838");
                ComposerKt.sourceInformationMarkerStart($composer5, -328167685, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv3 = ($dirty3 & 14) == 4;
                Object it$iv2 = $composer5.rememberedValue();
                if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(text, null, 2, null);
                    $composer5.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv2;
                }
                final MutableState displayedText$delegate = (MutableState) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                AnnotatedString annotatedStringBasicText_RWo7tUw$lambda$5 = BasicText_RWo7tUw$lambda$5(displayedText$delegate);
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer5.consume(localFontFamilyResolver);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                FontFamily.Resolver resolver = (FontFamily.Resolver) objConsume3;
                ComposerKt.sourceInformationMarkerStart($composer5, -328147596, "CC(remember):BasicText.kt#9igjgp");
                boolean invalid$iv4 = $composer5.changed(displayedText$delegate);
                Object it$iv3 = $composer5.rememberedValue();
                if (invalid$iv4 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function1) new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                            invoke2(textSubstitutionValue);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue substitutionValue) {
                            AnnotatedString original;
                            MutableState<AnnotatedString> mutableState = displayedText$delegate;
                            if (substitutionValue.isShowingSubstitution()) {
                                original = substitutionValue.getSubstitution();
                            } else {
                                original = substitutionValue.getOriginal();
                            }
                            mutableState.setValue(original);
                        }
                    };
                    $composer5.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                style3 = style2;
                $composer3 = $composer5;
                Modifier modifier4 = modifier3;
                m984LayoutWithLinksAndInlineContentvOo2fZY(modifier4, annotatedStringBasicText_RWo7tUw$lambda$5, onTextLayout5, hasInlineContent, inlineContent2, style3, overflow6, softWrap3, maxLines4, minLines3, resolver, selectionController, color3, (Function1) value$iv2, $composer3, (($dirty3 >> 3) & 14) | (($dirty3 >> 3) & 896) | (($dirty3 >> 12) & 57344) | (($dirty3 << 9) & 458752) | (($dirty3 << 6) & 3670016) | (($dirty3 << 6) & 29360128) | (($dirty3 << 6) & 234881024) | (($dirty3 << 6) & 1879048192), ($dirty3 >> 21) & 896, 0);
                onTextLayout3 = onTextLayout5;
                overflow3 = overflow6;
                modifier3 = modifier4;
                $composer3.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1584294453);
                ComposerKt.sourceInformation($composer2, "229@10603L7,217@10089L814");
                Modifier modifierM4347graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4347graphicsLayerAp8cVGQ$default(modifier3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver2 = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = $composer2.consume(localFontFamilyResolver2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextStyle style5 = style2;
                Function1 onTextLayout6 = onTextLayout2;
                Composer $composer6 = $composer2;
                softWrap3 = softWrap2;
                maxLines4 = maxLines3;
                Modifier modifier$iv = m986textModifiercFh6CEA(modifierM4347graphicsLayerAp8cVGQ$default, text, style5, onTextLayout6, overflow6, softWrap3, maxLines4, minLines3, (FontFamily.Resolver) objConsume4, null, null, selectionController, color3, null);
                MeasurePolicy measurePolicy$iv = EmptyMeasurePolicy.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer6, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer6, 0);
                Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
                CompositionLocalMap localMap$iv = $composer6.getCurrentCompositionLocalMap();
                Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart($composer6, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv = factory$iv$iv2;
                    $composer6.createNode(factory$iv$iv);
                } else {
                    factory$iv$iv = factory$iv$iv2;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u241$iv = Updater.m3678constructorimpl($composer6);
                Updater.m3685setimpl($this$Layout_u24lambda_u241$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u241$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m3685setimpl($this$Layout_u24lambda_u241$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
                Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u241$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u241$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                    $this$Layout_u24lambda_u241$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                    $this$Layout_u24lambda_u241$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
                }
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endReplaceGroup();
                onTextLayout3 = onTextLayout6;
                style3 = style5;
                $composer3 = $composer6;
                overflow3 = overflow6;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            maxLines5 = maxLines4;
            minLines2 = minLines3;
            color2 = color3;
            inlineContent = inlineContent2;
            modifier2 = modifier3;
            softWrap2 = softWrap3;
            overflow4 = overflow3;
            onTextLayout4 = onTextLayout3;
            style4 = style3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final int maxLines7 = maxLines5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i15) {
                    BasicTextKt.m981BasicTextRWo7tUw(text, modifier5, style4, onTextLayout4, overflow4, softWrap2, maxLines7, minLines2, inlineContent, color2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final AnnotatedString BasicText_RWo7tUw$lambda$5(MutableState<AnnotatedString> mutableState) {
        MutableState<AnnotatedString> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM, reason: not valid java name */
    public static final /* synthetic */ void m980BasicTextBpD7jsM(final String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Composer $composer, final int $changed, final int i) {
        String str;
        Modifier modifier2;
        TextStyle style2;
        Function1 onTextLayout2;
        int overflow2;
        boolean softWrap2;
        Modifier modifier3;
        final TextStyle style3;
        final Function1 onTextLayout3;
        final int overflow3;
        final int maxLines2;
        final boolean softWrap3;
        Composer $composer2 = $composer.startRestartGroup(1022429478);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)279@12355L234:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            str = text;
        } else if (($changed & 6) == 0) {
            str = text;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = text;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            style2 = style;
        } else if (($changed & 384) == 0) {
            style2 = style;
            $dirty |= $composer2.changed(style2) ? 256 : 128;
        } else {
            style2 = style;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onTextLayout2 = onTextLayout;
        } else if (($changed & 3072) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty |= $composer2.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else if (($changed & 24576) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if ((196608 & $changed) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            Function1 function1 = onTextLayout2;
            modifier3 = modifier2;
            onTextLayout3 = function1;
            maxLines2 = maxLines;
            style3 = style2;
            overflow3 = overflow2;
            softWrap3 = softWrap2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i4 != 0) {
                onTextLayout2 = null;
            }
            if (i5 != 0) {
                overflow2 = TextOverflow.INSTANCE.m6599getClipgIe3tQ8();
            }
            if (i6 != 0) {
                softWrap2 = true;
            }
            int maxLines3 = i7 != 0 ? Integer.MAX_VALUE : maxLines;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1022429478, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:278)");
            }
            TextStyle style4 = style2;
            int overflow4 = overflow2;
            Function1 onTextLayout4 = onTextLayout2;
            modifier3 = modifier4;
            m983BasicTextVhcvRP8(str, modifier3, style4, (Function1<? super TextLayoutResult, Unit>) onTextLayout4, overflow4, softWrap2, maxLines3, 1, (ColorProducer) null, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            style3 = style4;
            onTextLayout3 = onTextLayout4;
            overflow3 = overflow4;
            maxLines2 = maxLines3;
            softWrap3 = softWrap2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    BasicTextKt.m980BasicTextBpD7jsM(text, modifier5, style3, onTextLayout3, overflow3, softWrap3, maxLines2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE, reason: not valid java name */
    public static final /* synthetic */ void m978BasicText4YKlhWE(final AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, Map inlineContent, Composer $composer, final int $changed, final int i) {
        AnnotatedString annotatedString;
        Modifier modifier2;
        TextStyle style2;
        Function1 onTextLayout2;
        int overflow2;
        boolean softWrap2;
        int i2;
        Modifier modifier3;
        final TextStyle style3;
        final Function1 onTextLayout3;
        final int overflow3;
        final boolean softWrap3;
        final int maxLines2;
        final Map inlineContent2;
        Composer $composer2 = $composer.startRestartGroup(-648605928);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)303@13046L273:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            annotatedString = text;
        } else if (($changed & 6) == 0) {
            annotatedString = text;
            $dirty |= $composer2.changed(annotatedString) ? 4 : 2;
        } else {
            annotatedString = text;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            style2 = style;
        } else if (($changed & 384) == 0) {
            style2 = style;
            $dirty |= $composer2.changed(style2) ? 256 : 128;
        } else {
            style2 = style;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onTextLayout2 = onTextLayout;
        } else if (($changed & 3072) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty |= $composer2.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else if (($changed & 24576) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if ((196608 & $changed) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
            i2 = i9;
        } else if (($changed & 12582912) == 0) {
            i2 = i9;
            $dirty |= $composer2.changedInstance(inlineContent) ? 8388608 : 4194304;
        } else {
            i2 = i9;
        }
        if (($dirty & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            maxLines2 = maxLines;
            modifier3 = modifier2;
            style3 = style2;
            onTextLayout3 = onTextLayout2;
            overflow3 = overflow2;
            softWrap3 = softWrap2;
            inlineContent2 = inlineContent;
        } else {
            Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
            if (i4 != 0) {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i5 != 0) {
                onTextLayout2 = null;
            }
            if (i6 != 0) {
                overflow2 = TextOverflow.INSTANCE.m6599getClipgIe3tQ8();
            }
            if (i7 != 0) {
                softWrap2 = true;
            }
            int maxLines3 = i8 != 0 ? Integer.MAX_VALUE : maxLines;
            Map inlineContent3 = i2 != 0 ? MapsKt.emptyMap() : inlineContent;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-648605928, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:302)");
            }
            modifier3 = modifier4;
            int maxLines4 = maxLines3;
            Function1 onTextLayout4 = onTextLayout2;
            boolean softWrap4 = softWrap2;
            int overflow4 = overflow2;
            TextStyle style4 = style2;
            m981BasicTextRWo7tUw(annotatedString, modifier3, style4, onTextLayout4, overflow4, softWrap4, maxLines4, 1, inlineContent3, null, $composer2, ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (($dirty << 3) & 234881024), 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            style3 = style4;
            onTextLayout3 = onTextLayout4;
            overflow3 = overflow4;
            softWrap3 = softWrap4;
            maxLines2 = maxLines4;
            inlineContent2 = inlineContent3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    BasicTextKt.m978BasicText4YKlhWE(text, modifier5, style3, onTextLayout3, overflow3, softWrap3, maxLines2, inlineContent2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-4YKlhWE, reason: not valid java name */
    public static final /* synthetic */ void m979BasicText4YKlhWE(final String text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Composer $composer, final int $changed, final int i) {
        String str;
        Modifier modifier2;
        TextStyle style2;
        Function1 onTextLayout2;
        int overflow2;
        boolean softWrap2;
        int i2;
        Modifier.Companion modifier3;
        int maxLines2;
        int minLines2;
        Modifier modifier4;
        final TextStyle style3;
        final Function1 onTextLayout3;
        final int overflow3;
        final boolean softWrap3;
        final int maxLines3;
        final int minLines3;
        Composer $composer2 = $composer.startRestartGroup(1542716361);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5)327@13717L86:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            str = text;
        } else if (($changed & 6) == 0) {
            str = text;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = text;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            style2 = style;
        } else if (($changed & 384) == 0) {
            style2 = style;
            $dirty |= $composer2.changed(style2) ? 256 : 128;
        } else {
            style2 = style;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onTextLayout2 = onTextLayout;
        } else if (($changed & 3072) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty |= $composer2.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else if (($changed & 24576) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if ((196608 & $changed) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
            i2 = i9;
        } else if (($changed & 12582912) == 0) {
            i2 = i9;
            $dirty |= $composer2.changed(minLines) ? 8388608 : 4194304;
        } else {
            i2 = i9;
        }
        if (($dirty & 4793491) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            maxLines3 = maxLines;
            modifier4 = modifier2;
            style3 = style2;
            onTextLayout3 = onTextLayout2;
            overflow3 = overflow2;
            softWrap3 = softWrap2;
            minLines3 = minLines;
        } else {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i5 != 0) {
                onTextLayout2 = null;
            }
            if (i6 != 0) {
                overflow2 = TextOverflow.INSTANCE.m6599getClipgIe3tQ8();
            }
            if (i7 != 0) {
                softWrap2 = true;
            }
            if (i8 == 0) {
                maxLines2 = maxLines;
            } else {
                maxLines2 = Integer.MAX_VALUE;
            }
            if (i2 == 0) {
                minLines2 = minLines;
            } else {
                minLines2 = 1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1542716361, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:327)");
            }
            modifier4 = modifier3;
            int maxLines4 = maxLines2;
            Function1 onTextLayout4 = onTextLayout2;
            boolean softWrap4 = softWrap2;
            int overflow4 = overflow2;
            TextStyle style4 = style2;
            m983BasicTextVhcvRP8(str, modifier4, style4, (Function1<? super TextLayoutResult, Unit>) onTextLayout4, overflow4, softWrap4, maxLines4, minLines2, (ColorProducer) null, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            style3 = style4;
            onTextLayout3 = onTextLayout4;
            overflow3 = overflow4;
            softWrap3 = softWrap4;
            maxLines3 = maxLines4;
            minLines3 = minLines2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    BasicTextKt.m979BasicText4YKlhWE(text, modifier5, style3, onTextLayout3, overflow3, softWrap3, maxLines3, minLines3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-VhcvRP8, reason: not valid java name */
    public static final /* synthetic */ void m982BasicTextVhcvRP8(final AnnotatedString text, Modifier modifier, TextStyle style, Function1 onTextLayout, int overflow, boolean softWrap, int maxLines, int minLines, Map inlineContent, Composer $composer, final int $changed, final int i) {
        AnnotatedString annotatedString;
        Modifier modifier2;
        TextStyle style2;
        Function1 onTextLayout2;
        int overflow2;
        boolean softWrap2;
        int i2;
        int i3;
        int minLines2;
        final TextStyle style3;
        final int overflow3;
        final boolean softWrap3;
        final int maxLines2;
        final Map inlineContent2;
        Composer $composer2 = $composer.startRestartGroup(851408699);
        ComposerKt.sourceInformation($composer2, "C(BasicText)P(8,3,7,4,5:c#ui.text.style.TextOverflow,6,1,2)341@14269L240:BasicText.kt#423gt5");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            annotatedString = text;
        } else if (($changed & 6) == 0) {
            annotatedString = text;
            $dirty |= $composer2.changed(annotatedString) ? 4 : 2;
        } else {
            annotatedString = text;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            style2 = style;
        } else if (($changed & 384) == 0) {
            style2 = style;
            $dirty |= $composer2.changed(style2) ? 256 : 128;
        } else {
            style2 = style;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            onTextLayout2 = onTextLayout;
        } else if (($changed & 3072) == 0) {
            onTextLayout2 = onTextLayout;
            $dirty |= $composer2.changedInstance(onTextLayout2) ? 2048 : 1024;
        } else {
            onTextLayout2 = onTextLayout;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            overflow2 = overflow;
        } else if (($changed & 24576) == 0) {
            overflow2 = overflow;
            $dirty |= $composer2.changed(overflow2) ? 16384 : 8192;
        } else {
            overflow2 = overflow;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            softWrap2 = softWrap;
        } else if ((196608 & $changed) == 0) {
            softWrap2 = softWrap;
            $dirty |= $composer2.changed(softWrap2) ? 131072 : 65536;
        } else {
            softWrap2 = softWrap;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changed(maxLines) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
            i2 = i10;
        } else if (($changed & 12582912) == 0) {
            i2 = i10;
            $dirty |= $composer2.changed(minLines) ? 8388608 : 4194304;
        } else {
            i2 = i10;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
            i3 = i11;
        } else if (($changed & 100663296) == 0) {
            i3 = i11;
            $dirty |= $composer2.changedInstance(inlineContent) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i11;
        }
        if (($dirty & 38347923) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            maxLines2 = maxLines;
            minLines2 = minLines;
            inlineContent2 = inlineContent;
            style3 = style2;
            overflow3 = overflow2;
            softWrap3 = softWrap2;
        } else {
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                style2 = TextStyle.INSTANCE.getDefault();
            }
            if (i6 != 0) {
                onTextLayout2 = null;
            }
            if (i7 != 0) {
                overflow2 = TextOverflow.INSTANCE.m6599getClipgIe3tQ8();
            }
            if (i8 != 0) {
                softWrap2 = true;
            }
            int maxLines3 = i9 != 0 ? Integer.MAX_VALUE : maxLines;
            int minLines3 = i2 != 0 ? 1 : minLines;
            Map inlineContent3 = i3 != 0 ? MapsKt.emptyMap() : inlineContent;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851408699, $dirty, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:341)");
            }
            int maxLines4 = maxLines3;
            minLines2 = minLines3;
            TextStyle style4 = style2;
            int overflow4 = overflow2;
            boolean softWrap4 = softWrap2;
            Modifier modifier3 = modifier2;
            Function1 onTextLayout3 = onTextLayout2;
            m981BasicTextRWo7tUw(annotatedString, modifier3, style4, onTextLayout3, overflow4, softWrap4, maxLines4, minLines2, inlineContent3, null, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty), 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            style3 = style4;
            onTextLayout2 = onTextLayout3;
            overflow3 = overflow4;
            softWrap3 = softWrap4;
            maxLines2 = maxLines4;
            inlineContent2 = inlineContent3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function1 onTextLayout4 = onTextLayout2;
            final int minLines4 = minLines2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    BasicTextKt.m982BasicTextVhcvRP8(text, modifier4, style3, onTextLayout4, overflow3, softWrap3, maxLines2, minLines4, inlineContent2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2<SaverScope, Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt.selectionIdSaver.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(SaverScope saverScope, Long l) {
                return invoke(saverScope, l.longValue());
            }

            public final Long invoke(SaverScope $this$Saver, long it) {
                if (SelectionRegistrarKt.hasSelection(selectionRegistrar, it)) {
                    return Long.valueOf(it);
                }
                return null;
            }
        }, new Function1<Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt.selectionIdSaver.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Long invoke(long it) {
                return Long.valueOf(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (function0.invoke().booleanValue()) {
            TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
            List $this$fastMapIndexedNotNull$iv = list;
            int $i$f$fastMapIndexedNotNull = 0;
            ArrayList target$iv = new ArrayList($this$fastMapIndexedNotNull$iv.size());
            List $this$fastForEachIndexed$iv$iv = $this$fastMapIndexedNotNull$iv;
            int index$iv$iv = 0;
            int size = $this$fastForEachIndexed$iv$iv.size();
            while (index$iv$iv < size) {
                Object item$iv$iv = $this$fastForEachIndexed$iv$iv.get(index$iv$iv);
                Measurable measurable = (Measurable) item$iv$iv;
                Object parentData = measurable.getParentData();
                Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
                TextRangeScopeMeasurePolicy rangeMeasurePolicy = ((TextRangeLayoutModifier) parentData).getMeasurePolicy();
                TextRangeLayoutMeasureResult rangeMeasureResult = rangeMeasurePolicy.measure(textRangeLayoutMeasureScope);
                TextRangeLayoutMeasureScope textRangeLayoutMeasureScope2 = textRangeLayoutMeasureScope;
                Constraints.Companion companion = Constraints.INSTANCE;
                List $this$fastMapIndexedNotNull$iv2 = $this$fastMapIndexedNotNull$iv;
                int width = rangeMeasureResult.getWidth();
                int $i$f$fastMapIndexedNotNull2 = $i$f$fastMapIndexedNotNull;
                int $i$f$fastMapIndexedNotNull3 = rangeMeasureResult.getWidth();
                ArrayList target$iv2 = target$iv;
                Placeable placeable = measurable.mo5535measureBRTryo0(companion.m6645fitPrioritizingWidthZbe2FdA(width, $i$f$fastMapIndexedNotNull3, rangeMeasureResult.getHeight(), rangeMeasureResult.getHeight()));
                target$iv2.add(new Pair(placeable, rangeMeasureResult.getPlace()));
                index$iv$iv++;
                textRangeLayoutMeasureScope = textRangeLayoutMeasureScope2;
                $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                $i$f$fastMapIndexedNotNull = $i$f$fastMapIndexedNotNull2;
                target$iv = target$iv2;
                $this$fastForEachIndexed$iv$iv = $this$fastForEachIndexed$iv$iv;
            }
            return target$iv;
        }
        return null;
    }

    /* renamed from: textModifier-cFh6CEA, reason: not valid java name */
    private static final Modifier m986textModifiercFh6CEA(Modifier $this$textModifier_u2dcFh6CEA, AnnotatedString text, TextStyle style, Function1<? super TextLayoutResult, Unit> function1, int overflow, boolean softWrap, int maxLines, int minLines, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer color, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13) {
        if (selectionController == null) {
            TextAnnotatedStringElement staticTextModifier = new TextAnnotatedStringElement(text, style, fontFamilyResolver, function1, overflow, softWrap, maxLines, minLines, list, function12, null, color, function13, null);
            return $this$textModifier_u2dcFh6CEA.then(Modifier.INSTANCE).then(staticTextModifier);
        }
        SelectableTextAnnotatedStringElement selectableTextModifier = new SelectableTextAnnotatedStringElement(text, style, fontFamilyResolver, function1, overflow, softWrap, maxLines, minLines, list, function12, selectionController, color, null);
        return $this$textModifier_u2dcFh6CEA.then(selectionController.getModifier()).then(selectableTextModifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LayoutWithLinksAndInlineContent-vOo2fZY, reason: not valid java name */
    public static final void m984LayoutWithLinksAndInlineContentvOo2fZY(final Modifier modifier, final AnnotatedString annotatedString, final Function1<? super TextLayoutResult, Unit> function1, final boolean z, Map<String, InlineTextContent> map, final TextStyle textStyle, final int i, final boolean z2, final int i2, final int i3, final FontFamily.Resolver resolver, final SelectionController selectionController, final ColorProducer colorProducer, final Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function12, Composer composer, final int i4, final int i5, final int i6) {
        Modifier modifier2;
        Map<String, InlineTextContent> map2;
        TextStyle textStyle2;
        int i7;
        boolean z3;
        final TextLinkScope textLinkScope;
        Function0 function0;
        Map<String, InlineTextContent> map3;
        Function0 function02;
        final MutableState mutableState;
        List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list;
        Function1 function13;
        Object obj;
        Object obj2;
        TextMeasurePolicy textMeasurePolicy;
        final Map<String, InlineTextContent> map4;
        Object obj3;
        Object objMutableStateOf$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(645129368);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LayoutWithLinksAndInlineContent)P(6,13,8,2,3,12,9:c#ui.text.style.TextOverflow,11,4,5,1,10)578@22283L117,565@21843L1459:BasicText.kt#423gt5");
        int i8 = i4;
        int i9 = i5;
        if ((i6 & 1) != 0) {
            i8 |= 6;
            modifier2 = modifier;
        } else if ((i4 & 6) == 0) {
            modifier2 = modifier;
            i8 |= composerStartRestartGroup.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i6 & 2) != 0) {
            i8 |= 48;
        } else if ((i4 & 48) == 0) {
            i8 |= composerStartRestartGroup.changed(annotatedString) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i8 |= 384;
        } else if ((i4 & 384) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i8 |= 3072;
        } else if ((i4 & 3072) == 0) {
            i8 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i10 = i6 & 16;
        if (i10 != 0) {
            i8 |= 24576;
            map2 = map;
        } else if ((i4 & 24576) == 0) {
            map2 = map;
            i8 |= composerStartRestartGroup.changedInstance(map2) ? 16384 : 8192;
        } else {
            map2 = map;
        }
        if ((i6 & 32) != 0) {
            i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            textStyle2 = textStyle;
        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            textStyle2 = textStyle;
            i8 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        if ((i6 & 64) != 0) {
            i8 |= 1572864;
            i7 = i;
        } else if ((i4 & 1572864) == 0) {
            i7 = i;
            i8 |= composerStartRestartGroup.changed(i7) ? 1048576 : 524288;
        } else {
            i7 = i;
        }
        if ((i6 & 128) != 0) {
            i8 |= 12582912;
            z3 = z2;
        } else if ((12582912 & i4) == 0) {
            z3 = z2;
            i8 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
        } else {
            z3 = z2;
        }
        if ((i6 & 256) != 0) {
            i8 |= 100663296;
        } else if ((100663296 & i4) == 0) {
            i8 |= composerStartRestartGroup.changed(i2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i6 & 512) != 0) {
            i8 |= 805306368;
        } else if ((805306368 & i4) == 0) {
            i8 |= composerStartRestartGroup.changed(i3) ? 536870912 : 268435456;
        }
        if ((i6 & 1024) != 0) {
            i9 |= 6;
        } else if ((i5 & 6) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(resolver) ? 4 : 2;
        }
        if ((i6 & 2048) != 0) {
            i9 |= 48;
        } else if ((i5 & 48) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(selectionController) ? 32 : 16;
        }
        if ((i6 & 4096) != 0) {
            i9 |= 384;
        } else if ((i5 & 384) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(colorProducer) ? 256 : 128;
        }
        if ((i6 & 8192) != 0) {
            i9 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i9 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i8 & 306783379) == 306783378 && (i9 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            map4 = map2;
        } else {
            Map<String, InlineTextContent> mapEmptyMap = i10 != 0 ? MapsKt.emptyMap() : map2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(645129368, i8, i9, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)");
            }
            if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                composerStartRestartGroup.startReplaceGroup(-619323167);
                ComposerKt.sourceInformation(composerStartRestartGroup, "539@20954L38");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297072527, "CC(remember):BasicText.kt#9igjgp");
                boolean z4 = (i8 & 112) == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new TextLinkScope(annotatedString);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                textLinkScope = (TextLinkScope) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(-619265198);
                composerStartRestartGroup.endReplaceGroup();
                textLinkScope = null;
            }
            if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                composerStartRestartGroup.startReplaceGroup(-619074547);
                ComposerKt.sourceInformation(composerStartRestartGroup, "545@21203L90");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297064507, "CC(remember):BasicText.kt#9igjgp");
                boolean zChanged = ((i8 & 112) == 32) | composerStartRestartGroup.changed(textLinkScope);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final AnnotatedString invoke() {
                            AnnotatedString annotatedStringApplyAnnotators$foundation_release;
                            TextLinkScope textLinkScope2 = textLinkScope;
                            return (textLinkScope2 == null || (annotatedStringApplyAnnotators$foundation_release = textLinkScope2.applyAnnotators$foundation_release()) == null) ? annotatedString : annotatedStringApplyAnnotators$foundation_release;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-618966357);
                ComposerKt.sourceInformation(composerStartRestartGroup, "548@21307L8");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297061261, "CC(remember):BasicText.kt#9igjgp");
                boolean z5 = (i8 & 112) == 32;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function0) new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final AnnotatedString invoke() {
                            return annotatedString;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> pairResolveInlineContent = z ? AnnotatedStringResolveInlineContentKt.resolveInlineContent(annotatedString, mapEmptyMap) : new Pair<>(null, null);
            List<AnnotatedString.Range<Placeholder>> listComponent1 = pairResolveInlineContent.component1();
            List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> listComponent2 = pairResolveInlineContent.component2();
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-618671702);
                ComposerKt.sourceInformation(composerStartRestartGroup, "558@21610L61");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297051512, "CC(remember):BasicText.kt#9igjgp");
                map3 = mapEmptyMap;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                function02 = function0;
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
                } else {
                    objMutableStateOf$default = objRememberedValue4;
                }
                mutableState = (MutableState) objMutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                map3 = mapEmptyMap;
                function02 = function0;
                composerStartRestartGroup.startReplaceGroup(-618591630);
                composerStartRestartGroup.endReplaceGroup();
                mutableState = null;
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-618506565);
                ComposerKt.sourceInformation(composerStartRestartGroup, "562@21777L44");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297046185, "CC(remember):BasicText.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    list = listComponent2;
                } else {
                    list = listComponent2;
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function13 = (Function1) objRememberedValue5;
                }
                objRememberedValue5 = (Function1) new Function1<List<? extends Rect>, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$onPlaceholderLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Rect> list2) {
                        invoke2((List<Rect>) list2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<Rect> list2) {
                        MutableState<List<Rect>> mutableState2 = mutableState;
                        if (mutableState2 == null) {
                            return;
                        }
                        mutableState2.setValue(list2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                function13 = (Function1) objRememberedValue5;
            } else {
                list = listComponent2;
                composerStartRestartGroup.startReplaceGroup(-618442830);
                composerStartRestartGroup.endReplaceGroup();
                function13 = null;
            }
            Function1 function14 = function13;
            Modifier modifierM4347graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4347graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
            AnnotatedString annotatedString2 = (AnnotatedString) function02.invoke();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297029920, "CC(remember):BasicText.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(textLinkScope) | ((i8 & 896) == 256);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = (Function1) new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        TextLinkScope textLinkScope2 = textLinkScope;
                        if (textLinkScope2 != null) {
                            textLinkScope2.setTextLayoutResult(it);
                        }
                        Function1<TextLayoutResult, Unit> function15 = function1;
                        if (function15 != null) {
                            function15.invoke(it);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM986textModifiercFh6CEA = m986textModifiercFh6CEA(modifierM4347graphicsLayerAp8cVGQ$default, annotatedString2, textStyle2, (Function1) objRememberedValue6, i7, z3, i2, i3, resolver, listComponent1, function14, selectionController, colorProducer, function12);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-617202116);
                ComposerKt.sourceInformation(composerStartRestartGroup, "599@23147L55,600@23233L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297002334, "CC(remember):BasicText.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textLinkScope);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    obj = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$4$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextLinkScope it = textLinkScope;
                            return Boolean.valueOf(it != null ? it.getShouldMeasureLinks().invoke().booleanValue() : false);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue7;
                }
                Function0 function03 = (Function0) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -296999598, "CC(remember):BasicText.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(mutableState);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    obj2 = (Function0) new Function0<List<? extends Rect>>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final List<? extends Rect> invoke() {
                            MutableState<List<Rect>> mutableState2 = mutableState;
                            if (mutableState2 != null) {
                                return mutableState2.getValue();
                            }
                            return null;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj2);
                } else {
                    obj2 = objRememberedValue8;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextMeasurePolicy textMeasurePolicy2 = new TextMeasurePolicy(function03, (Function0) obj2);
                composerStartRestartGroup.endReplaceGroup();
                textMeasurePolicy = textMeasurePolicy2;
            } else {
                composerStartRestartGroup.startReplaceGroup(-617362851);
                ComposerKt.sourceInformation(composerStartRestartGroup, "595@22992L55");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -297007294, "CC(remember):BasicText.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(textLinkScope);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    obj3 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$3$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextLinkScope it = textLinkScope;
                            return Boolean.valueOf(it != null ? it.getShouldMeasureLinks().invoke().booleanValue() : false);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(obj3);
                } else {
                    obj3 = objRememberedValue9;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LinksTextMeasurePolicy linksTextMeasurePolicy = new LinksTextMeasurePolicy((Function0) obj3);
                composerStartRestartGroup.endReplaceGroup();
                textMeasurePolicy = linksTextMeasurePolicy;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM986textModifiercFh6CEA);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i11 = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3678constructorimpl = Updater.m3678constructorimpl(composerStartRestartGroup);
            Updater.m3685setimpl(composerM3678constructorimpl, textMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl(composerM3678constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3678constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3678constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3678constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3678constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3685setimpl(composerM3678constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i12 = (i11 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -515487512, "C:BasicText.kt#423gt5");
            if (textLinkScope == null) {
                composerStartRestartGroup.startReplaceGroup(-515480539);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(537560924);
                ComposerKt.sourceInformation(composerStartRestartGroup, "567@21894L18");
                textLinkScope.LinksComposables(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            }
            if (list == null) {
                composerStartRestartGroup.startReplaceGroup(-515428893);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-515428892);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*569@21966L48");
                AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString, list, composerStartRestartGroup, (i8 >> 3) & 14);
                Unit unit2 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            map4 = map3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    BasicTextKt.m984LayoutWithLinksAndInlineContentvOo2fZY(modifier, annotatedString, function1, z, map4, textStyle, i, z2, i2, i3, resolver, selectionController, colorProducer, function12, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                }
            });
        }
    }
}
