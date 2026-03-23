package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* compiled from: TextLinkScope.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u001e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001fJ>\u0010 \u001a\u00020\t2\u0016\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\"\"\u0004\u0018\u00010\u00012\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010$J\r\u0010%\u001a\u00020\u0003H\u0000¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u0010,\u001a\u0004\u0018\u00010-2\u0010\u0010.\u001a\f\u0012\u0004\u0012\u00020)0/j\u0002`0H\u0002J\u001c\u00101\u001a\u0004\u0018\u0001022\u0010\u0010.\u001a\f\u0012\u0004\u0012\u00020)0/j\u0002`0H\u0002J\u001a\u00103\u001a\u0004\u0018\u000104*\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u001c\u00106\u001a\u000207*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002R%\u0010\u0005\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0004R/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006;²\u0006\n\u0010<\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010=\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010>\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "getInitialText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "text", "getText$foundation_release", "setText$foundation_release", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "StyleAnnotation", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "applyAnnotators", "applyAnnotators$foundation_release", "handleLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "range", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/foundation/text/LinkRange;", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "textRange", "Landroidx/compose/ui/Modifier;", "start", "", "end", "foundation_release", "isHovered", "isFocused", "isPressed"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextLinkScope {
    public static final int $stable = 8;
    private final SnapshotStateList<Function1<TextAnnotatorScope, Unit>> annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;

    /* renamed from: textLayoutResult$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public TextLinkScope(AnnotatedString initialText) {
        SpanStyle style;
        this.initialText = initialText;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(this.initialText);
        List $this$fastForEach$iv = this.initialText.getLinkAnnotations(0, this.initialText.length());
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            AnnotatedString.Range link = (AnnotatedString.Range) item$iv;
            TextLinkStyles styles = link.getItem().getStyles();
            if (styles != null && (style = styles.getStyle()) != null) {
                builder.addStyle(style, link.getStart(), link.getEnd());
            }
        }
        this.text = builder.toAnnotatedString();
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    /* renamed from: getInitialText$foundation_release, reason: from getter */
    public final AnnotatedString getInitialText() {
        return this.initialText;
    }

    public final TextLayoutResult getTextLayoutResult() {
        State $this$getValue$iv = this.textLayoutResult;
        return (TextLayoutResult) $this$getValue$iv.getValue();
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        MutableState $this$setValue$iv = this.textLayoutResult;
        $this$setValue$iv.setValue(textLayoutResult);
    }

    /* renamed from: getText$foundation_release, reason: from getter */
    public final AnnotatedString getText() {
        return this.text;
    }

    public final void setText$foundation_release(AnnotatedString annotatedString) {
        this.text = annotatedString;
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        return new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextLinkScope$shouldMeasureLinks$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextLayoutInput layoutInput;
                AnnotatedString text = this.this$0.getText();
                TextLayoutResult textLayoutResult = this.this$0.getTextLayoutResult();
                return Boolean.valueOf(Intrinsics.areEqual(text, (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : layoutInput.getText()));
            }
        };
    }

    private final Modifier textRange(Modifier $this$textRange, final int start, final int end) {
        return $this$textRange.then(new TextRangeLayoutModifier(new TextRangeScopeMeasurePolicy() { // from class: androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda0
            @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
            public final TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
                return TextLinkScope.textRange$lambda$3(this.f$0, start, end, textRangeLayoutMeasureScope);
            }
        }));
    }

    static final TextRangeLayoutMeasureResult textRange$lambda$3(TextLinkScope this$0, int $start, int $end, TextRangeLayoutMeasureScope $this$$receiver) {
        TextLayoutResult layoutResult = this$0.getTextLayoutResult();
        if (layoutResult == null) {
            return $this$$receiver.layout(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$layoutResult$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ IntOffset invoke() {
                    return IntOffset.m6816boximpl(m1104invokenOccac());
                }

                /* renamed from: invoke-nOcc-ac, reason: not valid java name */
                public final long m1104invokenOccac() {
                    return IntOffset.INSTANCE.m6835getZeronOccac();
                }
            });
        }
        final IntRect bounds = IntRectKt.roundToIntRect(layoutResult.getPathForRange($start, $end).getBounds());
        return $this$$receiver.layout(bounds.getWidth(), bounds.getHeight(), new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ IntOffset invoke() {
                return IntOffset.m6816boximpl(m1103invokenOccac());
            }

            /* renamed from: invoke-nOcc-ac, reason: not valid java name */
            public final long m1103invokenOccac() {
                return bounds.m6853getTopLeftnOccac();
            }
        });
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> range) {
        final Path it = pathForRangeInRangeCoordinates(range);
        return it != null ? new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
            @Override // androidx.compose.ui.graphics.Shape
            /* renamed from: createOutline-Pq9zytI */
            public Outline mo278createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                return new Outline.Generic(it);
            }
        } : null;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> range) {
        TextLayoutResult it;
        float xOffset;
        if (!getShouldMeasureLinks().invoke().booleanValue() || (it = getTextLayoutResult()) == null) {
            return null;
        }
        Path path = it.getPathForRange(range.getStart(), range.getEnd());
        Rect firstCharBoundingBox = it.getBoundingBox(range.getStart());
        Rect lastCharBoundingBox = it.getBoundingBox(range.getEnd() - 1);
        int rangeStartLine = it.getLineForOffset(range.getStart());
        int rangeEndLine = it.getLineForOffset(range.getEnd());
        if (rangeStartLine == rangeEndLine) {
            xOffset = Math.min(lastCharBoundingBox.getLeft(), firstCharBoundingBox.getLeft());
        } else {
            xOffset = 0.0f;
        }
        float yOffset = firstCharBoundingBox.getTop();
        path.mo4082translatek4lQ0M(Offset.m3954unaryMinusF1C5BW0(OffsetKt.Offset(xOffset, yOffset)));
        return path;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void LinksComposables(androidx.compose.runtime.Composer r39, final int r40) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLinkScope.LinksComposables(androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$9(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$10(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LinksComposables$lambda$13$lambda$11(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpanStyle mergeOrUse(SpanStyle $this$mergeOrUse, SpanStyle other) {
        SpanStyle spanStyleMerge;
        return ($this$mergeOrUse == null || (spanStyleMerge = $this$mergeOrUse.merge(other)) == null) ? other : spanStyleMerge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        LinkInteractionListener linkInteractionListener;
        Unit unit;
        if (!(link instanceof LinkAnnotation.Url)) {
            if (!(link instanceof LinkAnnotation.Clickable) || (linkInteractionListener = link.getLinkInteractionListener()) == null) {
                return;
            }
            linkInteractionListener.onClick(link);
            return;
        }
        LinkInteractionListener linkInteractionListener2 = link.getLinkInteractionListener();
        if (linkInteractionListener2 != null) {
            linkInteractionListener2.onClick(link);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            try {
                uriHandler.openUri(((LinkAnnotation.Url) link).getUrl());
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public final AnnotatedString applyAnnotators$foundation_release() {
        AnnotatedString styledText;
        if (this.annotators.isEmpty()) {
            styledText = this.text;
        } else {
            AnnotatedString.Builder $this$applyAnnotators_u24lambda_u2415 = new AnnotatedString.Builder(0, 1, null);
            $this$applyAnnotators_u24lambda_u2415.append(this.initialText);
            TextAnnotatorScope scope = new TextAnnotatorScope($this$applyAnnotators_u24lambda_u2415);
            List $this$fastForEach$iv = this.annotators;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                Function1 it = (Function1) item$iv;
                it.invoke(scope);
            }
            styledText = $this$applyAnnotators_u24lambda_u2415.toAnnotatedString();
        }
        this.text = styledText;
        return styledText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void StyleAnnotation(final Object[] keys, final Function1<? super TextAnnotatorScope, Unit> function1, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-2083052099);
        ComposerKt.sourceInformation($composer2, "C(StyleAnnotation)P(1)238@10311L117,238@10280L148:TextLinkScope.kt#423gt5");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 256 : 128;
        }
        $composer2.startMovableGroup(-416717687, Integer.valueOf(keys.length));
        for (Object value : keys) {
            $dirty |= $composer2.changedInstance(value) ? 4 : 0;
        }
        $composer2.endMovableGroup();
        if (($dirty & 14) == 0) {
            $dirty |= 2;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2083052099, $dirty, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:237)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(function1);
            spreadBuilder.addSpread(keys);
            Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            ComposerKt.sourceInformationMarkerStart($composer2, -416714451, "CC(remember):TextLinkScope.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(this) | (($dirty & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        this.this$0.annotators.add(function1);
                        final TextLinkScope textLinkScope = this.this$0;
                        final Function1<TextAnnotatorScope, Unit> function12 = function1;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                textLinkScope.annotators.remove(function12);
                            }
                        };
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(array, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope.StyleAnnotation.2
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

                public final void invoke(Composer composer, int i) {
                    TextLinkScope.this.StyleAnnotation(Arrays.copyOf(keys, keys.length), function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
